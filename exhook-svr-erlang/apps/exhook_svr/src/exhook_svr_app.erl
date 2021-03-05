%%%-------------------------------------------------------------------
%% @doc exhook_svr public API
%% @end
%%%-------------------------------------------------------------------

-module(exhook_svr_app).

-behaviour(application).
-behaviour(supervisor).

-export([start/2, stop/1]).

-export([init/1]).

-export([stats/0]).

start(_StartType, _StartArgs) ->
    %% grpc server
    Services = #{protos => [emqx_exhook_pb],
                 services => #{
                    'emqx.exhook.v1.HookProvider' => exhook_svr
                 }
                },
    Options = [],
    {ok, _} = grpc:start_server(exhook_svr, 9000, Services, Options),
    io:format("Start service exhook_svr on 9000 successfully!~n", []),
    %% magic line
    _ = exhook_svr:module_info(),
    %% counter
    ets:new(exhook_stats, [public, named_table, {write_concurrency, true}]),
    start_supervisor().

stop(_State) ->
    grpc:stop_server(exhook_svr),
    ok.

stats() ->
    Stats = ets:tab2list(exhook_stats),
    [{total, lists:sum([V || {_, V} <- Stats])}|Stats].

start_supervisor() ->
    supervisor:start_link({local, ?MODULE}, ?MODULE, []).

init([]) ->
    SupFlags = #{strategy => one_for_all,
                 intensity => 0,
                 period => 1},
    ChildSpecs = [],
    {ok, {SupFlags, ChildSpecs}}.
