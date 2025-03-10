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

-module(exhook_svr).

-behavior(emqx_exhook_v_1_hook_provider_bhvr).

%% gRPC server HookProvider callbacks
-export([ on_provider_loaded/2
        , on_provider_unloaded/2
        , on_client_connect/2
        , on_client_connack/2
        , on_client_connected/2
        , on_client_disconnected/2
        , on_client_authenticate/2
        , on_client_authorize/2
        , on_client_subscribe/2
        , on_client_unsubscribe/2
        , on_session_created/2
        , on_session_subscribed/2
        , on_session_unsubscribed/2
        , on_session_resumed/2
        , on_session_discarded/2
        , on_session_takenover/2
        , on_session_terminated/2
        , on_message_publish/2
        , on_message_delivered/2
        , on_message_dropped/2
        , on_message_acked/2
        ]).

-define(PORT, 9000).
-define(NAME, ?MODULE).

-spec on_provider_loaded(emqx_exhook_pb:provider_loaded_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:loaded_response(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.

on_provider_loaded(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{hooks => [
                     #{name => <<"client.connect">>},
                     #{name => <<"client.connack">>},
                     #{name => <<"client.connected">>},
                     #{name => <<"client.disconnected">>},
                     #{name => <<"client.authenticate">>},
                     #{name => <<"client.authorize">>},
                     #{name => <<"client.subscribe">>},
                     #{name => <<"client.unsubscribe">>},
                     #{name => <<"session.created">>},
                     #{name => <<"session.subscribed">>},
                     #{name => <<"session.unsubscribed">>},
                     #{name => <<"session.resumed">>},
                     #{name => <<"session.discarded">>},
                     #{name => <<"session.takenover">>},
                     #{name => <<"session.terminated">>},
                     #{name => <<"message.publish">>},
                     #{name => <<"message.delivered">>},
                     #{name => <<"message.acked">>}
                     %#{name => <<"message.dropped">>}
                    ]}, Md}.
-spec on_provider_unloaded(emqx_exhook_pb:provider_unloaded_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_provider_unloaded(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_client_connect(emqx_exhook_pb:client_connect_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_client_connect(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_client_connack(emqx_exhook_pb:client_connack_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_client_connack(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_client_connected(emqx_exhook_pb:client_connected_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_client_connected(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_client_disconnected(emqx_exhook_pb:client_disconnected_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_client_disconnected(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_client_authenticate(emqx_exhook_pb:client_authenticate_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:valued_response(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_client_authenticate(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{type => 'STOP_AND_RETURN', value => {bool_result, true}}, Md}.

-spec on_client_authorize(emqx_exhook_pb:client_authorize_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:valued_response(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_client_authorize(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{type => 'STOP_AND_RETURN', value => {bool_result, true}}, Md}.

-spec on_client_subscribe(emqx_exhook_pb:client_subscribe_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_client_subscribe(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_client_unsubscribe(emqx_exhook_pb:client_unsubscribe_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_client_unsubscribe(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_session_created(emqx_exhook_pb:session_created_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_session_created(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_session_subscribed(emqx_exhook_pb:session_subscribed_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_session_subscribed(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_session_unsubscribed(emqx_exhook_pb:session_unsubscribed_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_session_unsubscribed(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_session_resumed(emqx_exhook_pb:session_resumed_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_session_resumed(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_session_discarded(emqx_exhook_pb:session_discarded_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_session_discarded(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_session_takenover(emqx_exhook_pb:session_takenover_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_session_takenover(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_session_terminated(emqx_exhook_pb:session_terminated_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_session_terminated(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_message_publish(emqx_exhook_pb:message_publish_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:valued_response(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_message_publish(_Req = #{message := Msg}, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    NMsg = Msg#{payload => <<"hardcode payload by exhook-svr-erlang :)">>},
    {ok, #{type => 'STOP_AND_RETURN', value => {message, NMsg}}, Md}.

%% Case2: stop publish the 't/d' messages
%on_message_publish(_Req = #{message := Msg}, Md) ->
%    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
%    NMsg =
%        case maps:get(topic, Msg) of
%            <<"t/d">> ->
%                NHeader = maps:put(<<"allow_publish">>, <<"false">>,
%                                   maps:get(headers, Msg, #{})),
%                maps:put(payload, <<"">>, maps:put(headers, NHeader, Msg));
%            _ ->
%                Msg
%        end,
%    {ok, #{type => 'STOP_AND_RETURN', value => {message, NMsg}}, Md}.

-spec on_message_delivered(emqx_exhook_pb:message_delivered_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_message_delivered(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_message_dropped(emqx_exhook_pb:message_dropped_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_message_dropped(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.

-spec on_message_acked(emqx_exhook_pb:message_acked_request(), grpc:metadata())
    -> {ok, emqx_exhook_pb:empty_success(), grpc:metadata()}
     | {error, grpc_cowboy_h:error_response()}.
on_message_acked(_Req, Md) ->
    ets:update_counter(exhook_stats, ?FUNCTION_NAME, {2, 1}, {?FUNCTION_NAME, 0}),
    {ok, #{}, Md}.
