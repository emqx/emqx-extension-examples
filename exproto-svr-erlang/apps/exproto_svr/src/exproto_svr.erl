%%--------------------------------------------------------------------
%% Copyright (c) 2020 EMQ Technologies Co., Ltd. All Rights Reserved.
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

-module(exproto_svr).

-behavior(emqx_exproto_v_1_connection_handler_bhvr).

-export([ frame_connect/2
        , frame_connack/1
        , frame_publish/3
        , frame_puback/1
        , frame_subscribe/2
        , frame_suback/1
        , frame_unsubscribe/1
        , frame_unsuback/1
        , frame_disconnect/0
        ]).

-export([ on_socket_created/2
        , on_received_bytes/2
        , on_socket_closed/2
        , on_timer_timeout/2
        , on_received_messages/2
        ]).

-define(LOG(Fmt, Args), io:format(standard_error, Fmt, Args)).

-define(HTTP, #{grpc_opts => #{service_protos => [emqx_exproto_pb],
                               services => #{'emqx.exproto.v1.ConnectionHandler' => ?MODULE}},
                listen_opts => #{port => 9001,
                                 socket_options => []},
                pool_opts => #{size => 8},
                transport_opts => #{ssl => false}}).

-define(CLIENT, emqx_exproto_v_1_connection_adapter_client).

-define(send(Req),         ?CLIENT:send(Req, #{channel => ct_test_channel})).
-define(close(Req),        ?CLIENT:close(Req, #{channel => ct_test_channel})).
-define(authenticate(Req), ?CLIENT:authenticate(Req, #{channel => ct_test_channel})).
-define(start_timer(Req),  ?CLIENT:start_timer(Req, #{channel => ct_test_channel})).
-define(publish(Req),      ?CLIENT:publish(Req, #{channel => ct_test_channel})).
-define(subscribe(Req),    ?CLIENT:subscribe(Req, #{channel => ct_test_channel})).
-define(unsubscribe(Req),  ?CLIENT:unsubscribe(Req, #{channel => ct_test_channel})).

-define(TYPE_CONNECT,     1).
-define(TYPE_CONNACK,     2).
-define(TYPE_PUBLISH,     3).
-define(TYPE_PUBACK,      4).
-define(TYPE_SUBSCRIBE,   5).
-define(TYPE_SUBACK,      6).
-define(TYPE_UNSUBSCRIBE, 7).
-define(TYPE_UNSUBACK,    8).
-define(TYPE_DISCONNECT,  9).

-define(loop_recv_and_reply_empty_success(Stream),
        ?loop_recv_and_reply_empty_success(Stream, fun(_) -> ok end)).

-define(loop_recv_and_reply_empty_success(Stream, Fun),
        begin
            LoopRecv = fun _Lp(_St) ->
                case grpc_stream:recv(_St) of
                    {more, _Reqs, _NSt} ->
                        ?LOG("~s ~p: ~p~n", [datetime(),
                                             ?FUNCTION_NAME, _Reqs]),
                        Fun(_Reqs), _Lp(_NSt);
                    {eos, _Reqs, _NSt} ->
                        ?LOG("~s ~p: ~p~n", [datetime(),
                                             ?FUNCTION_NAME, _Reqs]),
                        Fun(_Reqs), _NSt
                end
            end,
            NStream  = LoopRecv(Stream),
            grpc_stream:reply(NStream, #{}),
            {ok, NStream}
        end).

datetime() ->
    {{Y,M,D}, {H,Mm,S}} = calendar:local_time(),
    io_lib:format("~w-~w-~w ~w:~w:~w", [Y,M,D,H,Mm,S]).

%%--------------------------------------------------------------------
%% ConnectionHandler callbacks
%%--------------------------------------------------------------------

-spec on_socket_created(grpc_stream:stream(), grpc:metadata())
    -> {ok, grpc_stream:stream()}.
on_socket_created(Stream, _Md) ->
    ?loop_recv_and_reply_empty_success(Stream).

-spec on_socket_closed(grpc_stream:stream(), grpc:metadata())
    -> {ok, grpc_stream:stream()}.
on_socket_closed(Stream, _Md) ->
    ?loop_recv_and_reply_empty_success(Stream).

-spec on_received_bytes(grpc_stream:stream(), grpc:metadata())
    -> {ok, grpc_stream:stream()}.
on_received_bytes(Stream, _Md) ->
    ?loop_recv_and_reply_empty_success(Stream,
      fun(Reqs) ->
        statistics(runtime),
        statistics(wall_clock),
        lists:foreach(
          fun(#{conn := Conn, bytes := Bytes}) ->
            Remain = get_conn_recv_buffer(Conn),
            {NRemain, RawPackets} = parse_all_bytes(<<Remain/binary,
                                                      Bytes/binary>>),
            _ = put_conn_recv_buffer(Conn, NRemain),
            lists:foreach(fun(RawPacket) ->
                #{<<"type">> := Type} = Params
                                      = jsx:decode(RawPacket, [return_maps]),
                _ = handle_in(Conn, Type, Params)
            end, RawPackets)
          end, Reqs),
          {_, Time1} = statistics(runtime),
          {_, Time2} = statistics(wall_clock),
          io:format("~w -- CPU time: ~s, Procs time: ~s\n",
                    [length(Reqs), format_ts(Time1), format_ts(Time2)]),
          ok
      end).

format_ts(Ms) ->
    case Ms > 1000 of
        true ->
            lists:flatten(io_lib:format("~.2fs", [Ms/1000]));
        _ ->
            lists:flatten(io_lib:format("~wms", [Ms]))
    end.

get_conn_recv_buffer(Conn) ->
    case get({Conn, recvbuf}) of
        undefined -> <<>>;
        Bytes -> Bytes
    end.

put_conn_recv_buffer(Conn, Bytes) ->
    put({Conn, recvbuf}, Bytes).

parse_all_bytes(Bin) ->
    parse_all_bytes(Bin, <<>>, []).
parse_all_bytes(<<"##", Remain/binary>>, Buf, Acc) ->
    parse_all_bytes(Remain, <<>>, [Buf|Acc]);
parse_all_bytes(<<B, Remain/binary>>, Buf, Acc) ->
    parse_all_bytes(Remain, <<Buf/binary, B>>, Acc);
parse_all_bytes(<<>>, Buf, Acc) ->
    {Buf, Acc}.

-spec on_timer_timeout(grpc_stream:stream(), grpc:metadata())
    -> {ok, grpc_stream:stream()}.
on_timer_timeout(Stream, _Md) ->
    ?loop_recv_and_reply_empty_success(Stream,
      fun(Reqs) ->
        lists:foreach(
          fun(#{conn := Conn, type := 'KEEPALIVE'}) ->
            ?LOG("Close this connection ~p due to keepalive timeout", [Conn]),
            handle_out(Conn, ?TYPE_DISCONNECT),
            ?close(#{conn => Conn})
          end, Reqs)
      end).

-spec on_received_messages(grpc_stream:stream(), grpc:metadata())
    -> {ok, grpc_stream:stream()}.
on_received_messages(Stream, _Md) ->
    ?loop_recv_and_reply_empty_success(Stream,
      fun(Reqs) ->
        lists:foreach(
          fun(#{conn := Conn, messages := Messages}) ->
            lists:foreach(fun(Message) ->
                handle_out(Conn, ?TYPE_PUBLISH, Message)
            end, Messages)
          end, Reqs)
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
%%--------------------------------------------------------------------

handle_in(Conn, ?TYPE_CONNECT, #{<<"clientinfo">> := ClientInfo, <<"password">> := Password}) ->
    NClientInfo0 = maps:from_list([{binary_to_atom(K, utf8), V} || {K, V} <- maps:to_list(ClientInfo)]),
    NClientInfo = NClientInfo0#{
                    proto_name => <<"exproto-demo">>,
                    proto_ver => <<"1.0">>
                   },
    case ?authenticate(#{conn => Conn, clientinfo => NClientInfo, password => Password}) of
        {ok, #{code := 'SUCCESS'}, _} ->
            case maps:get(keepalive, NClientInfo, 5) of
                0 -> ok;
                Intv ->
                    io:format("Try call start_timer with ~ps", [Intv]),
                    ?start_timer(#{conn => Conn, type => 'KEEPALIVE', interval => Intv})
            end,
            handle_out(Conn, ?TYPE_CONNACK, 0);
        _ ->
            handle_out(Conn, ?TYPE_CONNACK, 1),
            ?close(#{conn => Conn})
    end;
handle_in(Conn, ?TYPE_PUBLISH, #{<<"topic">> := Topic,
                                 <<"qos">> := Qos,
                                 <<"payload">> := Payload}) ->
    case ?publish(#{conn => Conn, topic => Topic, qos => Qos, payload => Payload}) of
        {ok, #{code := 'SUCCESS'}, _} ->
            handle_out(Conn, ?TYPE_PUBACK, 0);
        _ ->
            handle_out(Conn, ?TYPE_PUBACK, 1)
    end;
handle_in(_Conn, ?TYPE_PUBACK, #{<<"code">> := _Code}) ->
    ok;
handle_in(Conn, ?TYPE_SUBSCRIBE, #{<<"qos">> := Qos, <<"topic">> := Topic}) ->
    case ?subscribe(#{conn => Conn, topic => Topic, qos => Qos}) of
        {ok, #{code := 'SUCCESS'}, _} ->
            handle_out(Conn, ?TYPE_SUBACK, 0);
        _ ->
            handle_out(Conn, ?TYPE_SUBACK, 1)
    end;
handle_in(Conn, ?TYPE_UNSUBSCRIBE, #{<<"topic">> := Topic}) ->
    case ?unsubscribe(#{conn => Conn, topic => Topic}) of
        {ok, #{code := 'SUCCESS'}, _} ->
            handle_out(Conn, ?TYPE_UNSUBACK, 0);
        _ ->
            handle_out(Conn, ?TYPE_UNSUBACK, 1)
    end;

handle_in(Conn, ?TYPE_DISCONNECT, _) ->
    ?close(#{conn => Conn}).

handle_out(Conn, ?TYPE_CONNACK, Code) ->
    ?send(#{conn => Conn, bytes => frame_connack(Code)});
handle_out(Conn, ?TYPE_PUBACK, Code) ->
    ?send(#{conn => Conn, bytes => frame_puback(Code)});
handle_out(Conn, ?TYPE_SUBACK, Code) ->
    ?send(#{conn => Conn, bytes => frame_suback(Code)});
handle_out(Conn, ?TYPE_UNSUBACK, Code) ->
    ?send(#{conn => Conn, bytes => frame_unsuback(Code)});
handle_out(Conn, ?TYPE_PUBLISH, #{qos := Qos, topic := Topic, payload := Payload}) ->
    ?send(#{conn => Conn, bytes => frame_publish(Topic, Qos, Payload)}).

handle_out(Conn, ?TYPE_DISCONNECT) ->
    ?send(#{conn => Conn, bytes => frame_disconnect()}).

%%--------------------------------------------------------------------
%% Frame

wrap(Bin) ->
    <<Bin/binary, "##">>.

frame_connect(ClientInfo, Password) ->
    wrap(jsx:encode(
           #{type => ?TYPE_CONNECT,
             clientinfo => ClientInfo,
             password => Password}
          )).

frame_connack(Code) ->
    wrap(jsx:encode(#{type => ?TYPE_CONNACK, code => Code})).

frame_publish(Topic, Qos, Payload) ->
    wrap(jsx:encode(
           #{type => ?TYPE_PUBLISH,
             topic => Topic,
             qos => Qos,
             payload => Payload}
          )).

frame_puback(Code) ->
    wrap(jsx:encode(#{type => ?TYPE_PUBACK, code => Code})).

frame_subscribe(Topic, Qos) ->
    wrap(jsx:encode(#{type => ?TYPE_SUBSCRIBE, topic => Topic, qos => Qos})).

frame_suback(Code) ->
    wrap(jsx:encode(#{type => ?TYPE_SUBACK, code => Code})).

frame_unsubscribe(Topic) ->
    wrap(jsx:encode(#{type => ?TYPE_UNSUBSCRIBE, topic => Topic})).

frame_unsuback(Code) ->
    wrap(jsx:encode(#{type => ?TYPE_UNSUBACK, code => Code})).

frame_disconnect() ->
    wrap(jsx:encode(#{type => ?TYPE_DISCONNECT})).
