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

start(_StartType, _StartArgs) ->
    %% grpc server
    Services = #{protos => [emqx_exproto_pb],
                 services => #{
                    'emqx.exproto.v1.ConnectionHandler' => exproto_svr
                 }
                },
    Options = [],
    {ok, _} = grpc:start_server(exproto_svr, 9001, Services, Options),
    io:format("Start service exproto_svr on 9001 successfully!~n", []),
    %% grpc client
    grpc_client_sup:create_channel_pool(ct_test_channel, "http://127.0.0.1:9100", #{}),
    %% magic line
    _ = exproto_svr:module_info(),
    %% counter
    ets:new(exproto_stats, [public, named_table, {write_concurrency, true}]),
    start_supervisor().

stop(_State) ->
    grpc:stop_server(exproto_svr),
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
