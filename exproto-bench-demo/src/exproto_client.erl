%--------------------------------------------------------------------
%% Copyright (c) 2019-2021 EMQ Technologies Co., Ltd. All Rights Reserved.
%%
%% Licensed under the Apache License, Version 2.0 (the "License");
%% you may not use this file except in compliance with the License.
%% You may obtain a copy of the License at
%%
%%     http://www.apache.org/licenses/LICENSE-2.0
%%
%% Unless required by applicable law or agreed to in writing, software
%% distributed under the License is distributed on an "AS IS" BASIS,
%% WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
%% See the License for the specific language governing permissions and
%% limitations under the License.
%%--------------------------------------------------------------------

-module(exproto_client).

-behaviour(gen_statem).

%% API
-export([ start_link/1
        , connect/1
        , publish/3
        , subscribe/2
        , subscribe/3
        , unsubscribe/2
        , disconnect/1
        ]).

%% gen_statem callbacks
-export([ callback_mode/0
        , init/1
        , initialized/3
        , waiting_for_connack/3
        , connected/3
        , handle_event/4
        , terminate/3
        , code_change/4
        ]).

-define(TYPE_CONNECT,     1).
-define(TYPE_CONNACK,     2).
-define(TYPE_PUBLISH,     3).
-define(TYPE_PUBACK,      4).
-define(TYPE_SUBSCRIBE,   5).
-define(TYPE_SUBACK,      6).
-define(TYPE_UNSUBSCRIBE, 7).
-define(TYPE_UNSUBACK,    8).
-define(TYPE_DISCONNECT,  9).

-define(RC_SUCCESS,       0).
-define(RC_FAILURE,       1).

-define(CONNACK_PACKET(Code), #{<<"type">> := ?TYPE_CONNACK, <<"code">> := Code}).

-define(LOG(Level, Format, Args, State),
        begin
          (logger:log(Level, #{}, #{report_cb => fun(_) -> {"excli(~s): "++(Format), ([State#state.clientid|Args])} end}))
        end).

%%--------------------------------------------------------------------
%% The Protocol Example:
%%  CONN:
%%   {"type": 1, "clientinfo": {...}, "password": "xyz"}
%%
%%  CONNACK:
%%   {"type": 2, "code": 0}
%%
%%  PUBLISH:
%%   {"type": 3, "topic": "xxx", "payload": "", "qos": 0}
%%
%%  PUBACK:
%%   {"type": 4, "code": 0}
%%
%%  SUBSCRIBE:
%%   {"type": 5, "topic": "xxx", "qos": 1}
%%
%%  SUBACK:
%%   {"type": 6, "code": 0}
%%
%%  DISCONNECT:
%%   {"type": 7, "code": 1}

-define(DEFAULT_TCP_OPTIONS, [binary, {packet, raw}, {active, false},
                              {nodelay, true}]).

-type(qos() :: 0 | 1 | 2).

-type(host() :: inet:ip_address() | inet:hostname()).

-type option() :: {host, host()}
                | {port, inet:port_number()}
                | {tcp_opts, [gen_tcp:option()]}
                | {clientid, iodata()}
                | {username, iodata()}
                | {password, iodata()}
                | {keepalive, non_neg_integer()}.

-record(call, {id, from, req, ts}).

-record(state, { host = "localhost"
               , port = 7993
               , tcp_opts = []
               , clientid
               , username
               , password
               , keepalive = 0
               , sock
               , owner
               , pending_calls = []
               , keepalive_timer
               }).

%%--------------------------------------------------------------------
%% APIs
%%--------------------------------------------------------------------

-spec start_link([option()]) -> gen_statem:start_ret().
start_link(Options) ->
    Options1 = [{owner, self()}|Options],
    gen_statem:start_link(?MODULE, [Options1], []).

-spec connect(pid()) -> ok | {error, term()}.
connect(C) ->
    call(C, connect).

-spec publish(pid(), iodata(), iodata()) -> ok | {error, term()}.
publish(C, Topic, Payload) ->
    call(C, {publish, Topic, Payload}).

-spec subscribe(pid(), iodata()) -> ok | {error, term()}.
subscribe(C, Topic) ->
    subscribe(C, Topic, 0).

-spec subscribe(pid(), iodata(), qos()) -> ok | {error, term()}.
subscribe(C, Topic, Qos) ->
    call(C, {subscribe, Topic, Qos}).

-spec unsubscribe(pid(), iodata()) -> ok | {error, term()}.
unsubscribe(C, Topic) ->
    call(C, {unsubscribe, Topic}).

-spec disconnect(pid()) -> ok.
disconnect(C) ->
    call(C, disconnect).

%% @private
call(Client, Req) ->
    gen_statem:call(Client, Req, infinity).

%%--------------------------------------------------------------------
%% callbacks
%%--------------------------------------------------------------------

callback_mode() ->
    state_functions.

init([Options]) ->
    {ok, initialized, do_init(Options, #state{})}.

random_clientid() ->
    iolist_to_binary(["exproto-",
       [rand_char() || _ <- lists:seq(1, 5)]
      ]).

rand_char() ->
    case rand:uniform(3) of
        1 -> $0 + rand:uniform(10) - 1;
        2 -> $a + rand:uniform(26) - 1;
        3 -> $A + rand:uniform(26) - 1
    end.

%% @private
do_init([], St) ->
    case St#state.clientid of
        undefined ->
            St#state{clientid = random_clientid()};
        _ ->
            St
    end;
do_init([{owner, Owner}|Opts], St) ->
    do_init(Opts, St#state{owner = Owner});
do_init([{host, Host}|Opts], St) ->
    do_init(Opts, St#state{host = Host});
do_init([{port, Port}|Opts], St) ->
    do_init(Opts, St#state{port = Port});
do_init([{tcp_opts, TcpOpts}|Opts], St) ->
    do_init(Opts, St#state{tcp_opts = TcpOpts});
do_init([{clientid, ClientId}|Opts], St) ->
    do_init(Opts, St#state{clientid = ClientId});
do_init([{username, Username}|Opts], St) ->
    do_init(Opts, St#state{username = Username});
do_init([{password, Password}|Opts], St) ->
    do_init(Opts, St#state{password = Password});
do_init([{keepalive, Keepalive}|Opts], St) ->
    do_init(Opts, St#state{keepalive = timer:seconds(Keepalive)});
do_init([_|Opts], St) ->
    do_init(Opts, St).

initialized({call, From}, connect, St = #state{
                                           host = Host,
                                           port = Port,
                                           tcp_opts = TcpOpts0,
                                           clientid = ClientId,
                                           username = Username,
                                           password = Password}) ->
    TcpOpts = merge_opts(TcpOpts0, ?DEFAULT_TCP_OPTIONS),
    case gen_tcp:connect(Host, Port, TcpOpts, 5000) of
        {ok, Sock} ->
            ClientInfo = #{clientid => ClientId,
                           username => Username
                          },
            St1 = add_call(new_call(_Id = connect, From), St),
            case send(frame_connect(ClientInfo, Password), run_sock(St1#state{sock = Sock})) of
                NSt when is_record(NSt, state) ->
                    {next_state, waiting_for_connack, NSt, [5000]};
                Error = {error, Reason} ->
                    {stop_and_reply, Reason, [{reply, From, Error}]}
            end;
        Error = {error, Reason} ->
            {stop_and_reply, Reason, [{reply, From, Error}]}
    end;

initialized(EventType, EventContent, St) ->
    handle_event(EventType, EventContent, initialized, St).

waiting_for_connack(cast, ?CONNACK_PACKET(Code), St) ->
    case take_call(connect, St) of
        {value, #call{from = From}, St1} ->
            case Code == ?RC_SUCCESS of
                true ->
                    {next_state, connected, ensure_keepalive_timer(St1),
                     [{reply, From, ok}]};
                _ ->
                    Reason = {connack_error, Code},
                    {stop_and_reply, Reason, [{reply, From, {error, Reason}}]}
            end;
        false ->
            {stop, bad_connack}
    end;

waiting_for_connack(timeout, _Timeout, St) ->
    case take_call(connect, St) of
        {value, #call{from = From}, _State} ->
            Reply = {error, connack_timeout},
            {stop_and_reply, connack_timeout, [{reply, From, Reply}]};
        false -> {stop, connack_timeout}
    end;

waiting_for_connack(EventType, EventContent, State) ->
    case take_call(connect, State) of
        {value, #call{from = From}, _State} ->
            case handle_event(EventType, EventContent, waiting_for_connack, State) of
                {stop, Reason, State} ->
                    Reply = {error, {Reason, EventContent}},
                    {stop_and_reply, Reason, [{reply, From, Reply}]};
                StateCallbackResult ->
                    StateCallbackResult
            end;
        false -> {stop, connack_timeout}
    end.

connected({call, From}, {publish, Topic, Payload}, St) ->
    Call = new_call(_Id = publish, From),
    Data = frame_publish(Topic, _Qos = 0, Payload),
    NSt = add_call(Call, send(Data, St)),
    {keep_state, NSt, []};

connected({call, From}, {subscribe, Topic, Qos}, St) ->
    Call = new_call(_Id = subscribe, From),
    Data = frame_subscribe(Topic, Qos),
    NSt = add_call(Call, send(Data, St)),
    {keep_state, NSt, []};

connected({call, From}, {unsubscribe, Topic}, St) ->
    Call = new_call(_Id = unsubscribe, From),
    Data = frame_unsubscribe(Topic),
    NSt = add_call(Call, send(Data, St)),
    {keep_state, NSt, []};

connected({call, From}, disconnect, St) ->
    Data = frame_disconnect(),
    NSt = send(Data, St),
    {stop_and_reply, normal, [{reply, From, ok}], NSt};

connected(cast, #{<<"type">> := ?TYPE_PUBACK, <<"code">> := Code}, St) ->
    handle_ack(publish, Code, St);

connected(cast, #{<<"type">> := ?TYPE_SUBACK, <<"code">> := Code}, St) ->
    handle_ack(subscribe, Code, St);

connected(cast, #{<<"type">> := ?TYPE_UNSUBACK, <<"code">> := Code}, St) ->
    handle_ack(unsubscribe, Code, St);

connected(cast, Publish = #{<<"type">> := ?TYPE_PUBLISH},
          St = #state{owner = Owner}) ->
    Owner ! {publish, maps:without([<<"type">>], Publish)},
    Data = frame_puback(0),
    NSt = send(Data, St),
    {keep_state, NSt, []};

connected(EventType, EventContent, St) ->
    handle_event(EventType, EventContent, connected, St).

handle_event({call, From}, stop, _StateName, St) ->
    {stop_and_reply, normal, St, [{reply, From, ok}]};

handle_event(info, {tcp, _Sock, Data}, _StateName, St) ->
    ?LOG(debug, "RECV Data: ~p", [Data], St),
    process_incoming(Data, [], run_sock(St));

handle_event(info, {tcp_error, _Sock, Reason}, _StateName, St) ->
    ?LOG(error, "The connection error occured tcp_error, reason:~p",
                 [Reason], St),
    {stop, {shutdown, Reason}, St};

handle_event(info, {tcp_closed, _Sock}, _StateName, St) ->
    ?LOG(debug, "~p", [tcp_closed], St),
    {stop, {shutdown, tcp_closed}, St};

handle_event(info, {'EXIT', Owner, Reason}, _, State = #state{owner = Owner}) ->
    ?LOG(debug, "Got EXIT from owner, Reason: ~p", [Reason], State),
    {stop, {shutdown, Reason}, State};

handle_event(info, {inet_reply, _Sock, ok}, _, _State) ->
    keep_state_and_data;

handle_event(info, {inet_reply, _Sock, {error, Reason}}, _, State) ->
    ?LOG(error, "Got tcp error: ~p", [Reason], State),
    {stop, {shutdown, Reason}, State};

handle_event(info, EventContent = {'EXIT', _Pid, normal}, StateName, State) ->
    ?LOG(info, "State: ~s, Unexpected Event: (info, ~p)",
         [StateName, EventContent], State),
    keep_state_and_data;

handle_event(EventType = {call, From}, EventContent, StateName, State) ->
    ?LOG(error, "State: ~s, Unexpected Call Event: (~p, ~p)",
         [StateName, EventType, EventContent], State),
    {keep_state_and_data, [{reply, From, ok}]};
handle_event(EventType, EventContent, StateName, State) ->
    ?LOG(error, "State: ~s, Unexpected Event: (~p, ~p)",
         [StateName, EventType, EventContent], State),
    keep_state_and_data.

terminate(_Reason, _State, _Data) ->
    ok.

code_change(_OldVsn, State, Data, _Extra) ->
    {ok, State, Data}.

handle_ack(Type, Code, St) ->
    case take_call(Type, St) of
        {value, #call{from = From}, NSt} ->
            Reply = case Code of
                        0 -> ok;
                        _ -> {error, Code}
                    end,
            {keep_state, NSt, [{reply, From, Reply}]};
        false ->
            ?LOG(warning, "Unknown ~s ack!", [Type], St),
            keep_state_and_data
    end.

new_call(Id, From) ->
    new_call(Id, From, undefined).
new_call(Id, From, Req) ->
    #call{id = Id, from = From, req = Req, ts = os:timestamp()}.

add_call(Call, St = #state{pending_calls = Calls}) ->
    St#state{pending_calls = lists:reverse([Call | Calls])}.

take_call(Id, Data = #state{pending_calls = Calls}) ->
    case lists:keytake(Id, #call.id, Calls) of
        {value, Call, Left} ->
            {value, Call, Data#state{pending_calls = Left}};
        false -> false
    end.

run_sock(St = #state{sock = Sock}) ->
    inet:setopts(Sock, [{active, once}]), St.

%ensure_keepalive_timer(St= #state{keepalive = 0}) ->
%    St;
%ensure_keepalive_timer(St= #state{keepalive = I}) ->
%    ensure_keepalive_timer(I, St).
%ensure_keepalive_timer(I, St) when is_integer(I) ->
%    St#state{keepalive_timer = erlang:start_timer(I, self(), keepalive)}.

ensure_keepalive_timer(St) ->
    %% Nothing to do
    St.

send(Data, St = #state{sock = Sock}) ->
    ok = gen_tcp:send(Sock, Data),
    St.

%%--------------------------------------------------------------------
%% Incoming
%%--------------------------------------------------------------------

process_incoming(<<>>, Packets, St) ->
    {keep_state, St, next_events(Packets)};

process_incoming(Bytes, Packets, St) ->

    try jsx:decode(Bytes, [return_maps]) of
        Packet ->
            {keep_state, St, next_events([Packet|Packets])}
    catch
        error:Error -> {stop, Error}
    end.

-compile({inline, [next_events/1]}).
next_events([]) -> [];
next_events([Packet]) ->
    {next_event, cast, Packet};
next_events(Packets) ->
    [{next_event, cast, Packet} || Packet <- lists:reverse(Packets)].

-spec(merge_opts(list(), list()) -> list()).
merge_opts(Defaults, Options) ->
    lists:foldl(
      fun({Opt, Val}, Acc) ->
          lists:keystore(Opt, 1, Acc, {Opt, Val});
         (Opt, Acc) ->
          lists:usort([Opt | Acc])
      end, Defaults, Options).

%%--------------------------------------------------------------------
%% Frames
%%--------------------------------------------------------------------

frame_connect(ClientInfo, Password) ->
    jsx:encode(#{type => ?TYPE_CONNECT,
                 clientinfo => ClientInfo,
                 password => Password}).
%frame_connack(Code) ->
%    jsx:encode(#{type => ?TYPE_CONNACK, code => Code}).

frame_publish(Topic, Qos, Payload) ->
    jsx:encode(#{type => ?TYPE_PUBLISH,
                 topic => Topic,
                 qos => Qos,
                 payload => Payload}
              ).

frame_puback(Code) ->
    jsx:encode(#{type => ?TYPE_PUBACK, code => Code}).

frame_subscribe(Topic, Qos) ->
    jsx:encode(#{type => ?TYPE_SUBSCRIBE, topic => Topic, qos => Qos}).

%frame_suback(Code) ->
%    jsx:encode(#{type => ?TYPE_SUBACK, code => Code}).

frame_unsubscribe(Topic) ->
    jsx:encode(#{type => ?TYPE_UNSUBSCRIBE, topic => Topic}).

%frame_unsuback(Code) ->
%    jsx:encode(#{type => ?TYPE_UNSUBACK, code => Code}).

frame_disconnect() ->
    jsx:encode(#{type => ?TYPE_DISCONNECT}).
