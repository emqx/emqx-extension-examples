%%%-------------------------------------------------------------------
%% @doc exproto_svr public API
%% @end
%%%-------------------------------------------------------------------

-module(exproto_svr_app).

-behaviour(application).
-behaviour(supervisor).

-export([start/2, stop/1]).

-export([init/1]).

-export([stats/0]).

-define(DEFAULT_SERVER_ADDR, "http://127.0.0.1:9100").

start(_StartType, _StartArgs) ->
    %% grpc server
    Services = #{protos => [emqx_exproto_pb],
                 services => #{
                    'emqx.exproto.v1.ConnectionHandler' => exproto_svr
                 }
                },
    Options1 = [],
    Options2 = [{ssl_options,
                 [ {verify, verify_peer}
                 , {fail_if_no_peer_cert, false}]
                 ++ ssl_opts()
                }],
    {ok, _} = grpc:start_server(exproto_svr_http,  9001, Services, Options1),
    {ok, _} = grpc:start_server(exproto_svr_https, 9002, Services, Options2),
    io:format("Start exproto_svr http server on  9001 successfully!~n", []),
    io:format("Start exproto_svr https server on 9002 successfully!~n", []),

    %% grpc client
    Addr = env(server_addr, ?DEFAULT_SERVER_ADDR),
    grpc_client_sup:create_channel_pool(ct_test_channel, Addr, #{}),
    %% magic line
    _ = exproto_svr:module_info(),
    %% counter
    ets:new(exproto_stats, [public, named_table, {write_concurrency, true}]),
    start_supervisor().

stop(_State) ->
    grpc:stop_server(exproto_svr_http),
    grpc:stop_server(exproto_svr_https),
    ok.

stats() ->
    Stats = ets:tab2list(exproto_stats),
    [{total, lists:sum([V || {_, V} <- Stats])}|Stats].

start_supervisor() ->
    supervisor:start_link({local, ?MODULE}, ?MODULE, []).

init([]) ->
    SupFlags = #{strategy => one_for_all,
                 intensity => 0,
                 period => 1},
    ChildSpecs = [],
    {ok, {SupFlags, ChildSpecs}}.

env(Key, Def) ->
    case application:get_env(exproto_svr, Key) of
        {ok, Val} -> Val;
        undefined -> Def
    end.

ssl_opts() ->
    [ {cacertfile, env(cacertfile, "certs/cacert.pem")}
    , {certfile, env(certfile, "certs/cert.pem")}
    , {keyfile, env(keyfile, "certs/key.pem")}
    ].
