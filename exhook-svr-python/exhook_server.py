# Copyright 2015 gRPC authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
"""The Python implementation of the GRPC exhook server."""

from concurrent import futures
import logging
from multiprocessing.sharedctypes import Value

import grpc

import exhook_pb2
import exhook_pb2_grpc

class HookProvider(exhook_pb2_grpc.HookProviderServicer):

    def OnProviderLoaded(self, request, context):
        print("OnProviderLoaded:", request)
        specs = [exhook_pb2.HookSpec(name="client.connect"),
                 exhook_pb2.HookSpec(name="client.connack"),
                 exhook_pb2.HookSpec(name="client.connected"),
                 exhook_pb2.HookSpec(name="client.disconnected"),
                 exhook_pb2.HookSpec(name="client.authenticate"),
                 exhook_pb2.HookSpec(name="client.authorize"),
                 exhook_pb2.HookSpec(name="client.subscribe"),
                 exhook_pb2.HookSpec(name="client.unsubscribe"),

                 exhook_pb2.HookSpec(name="session.created"),
                 exhook_pb2.HookSpec(name="session.subscribed"),
                 exhook_pb2.HookSpec(name="session.unsubscribed"),
                 exhook_pb2.HookSpec(name="session.resumed"),
                 exhook_pb2.HookSpec(name="session.discarded"),
                 exhook_pb2.HookSpec(name="session.takenover"),
                 exhook_pb2.HookSpec(name="session.terminated"),

                 exhook_pb2.HookSpec(name="message.publish"),
                 exhook_pb2.HookSpec(name="message.delivered"),
                 exhook_pb2.HookSpec(name="message.acked"),
                 exhook_pb2.HookSpec(name="message.dropped")
                ]
        return exhook_pb2.LoadedResponse(hooks=specs)

    def OnProviderUnloaded(self, request, context):
        print("OnProviderUnloaded:", request)
        return exhook_pb2.EmptySuccess()

    def OnClientConnect(self, request, context):
        print("OnClientConnect:", request)
        return exhook_pb2.EmptySuccess()

    def OnClientConnack(self, request, context):
        print("OnClientConnack:", request)
        return exhook_pb2.EmptySuccess()

    def OnClientConnected(self, request, context):
        print("OnClientConnected:", request)
        return exhook_pb2.EmptySuccess()

    def OnClientDisconnected(self, request, context):
        print("OnClientDisconnected:", request)
        return exhook_pb2.EmptySuccess()

    def OnClientAuthenticate(self, request, context):
        print("OnClientAuthenticate:", request)
        reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", bool_result=True)
        return reply

    def OnClientAuthorize(self, request, context):
        print("OnClientAuthorize:", request)
        reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", bool_result=True)
        return reply

    def OnClientSubscribe(self, request, context):
        print("OnClientSubscribe:", request)
        return exhook_pb2.EmptySuccess()

    def OnClientUnsubscribe(self, request, context):
        print("OnClientUnsubscribe:", request)
        return exhook_pb2.EmptySuccess()

    def OnSessionCreated(self, request, context):
        print("OnSessionCreated:", request)
        return exhook_pb2.EmptySuccess()

    def OnSessionSubscribed(self, request, context):
        print("OnSessionSubscribed:", request)
        return exhook_pb2.EmptySuccess()

    def OnSessionUnsubscribed(self, request, context):
        print("OnSessionUnsubscribed:", request)
        return exhook_pb2.EmptySuccess()

    def OnSessionResumed(self, request, context):
        print("OnSessionResumed:", request)
        return exhook_pb2.EmptySuccess()

    def OnSessionDiscarded(self, request, context):
        print("OnSessionDiscarded:", request)
        return exhook_pb2.EmptySuccess()

    def OnSessionTakenover(self, request, context):
        print("OnSessionTakenover:", request)
        return exhook_pb2.EmptySuccess()

    def OnSessionTerminated(self, request, context):
        print("OnSessionTerminated:", request)
        return exhook_pb2.EmptySuccess()


    ## case1: stop and then publish the hardcoded 't/d' messages
    ##
    def OnMessagePublish(self, request, context):
        print("OnMessagePublish:", request)
        nmsg = request.message
        nmsg.payload = b"{\"mgs\": \"hardcode payload by exhook-svr-python :)\"}"

        reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", message=nmsg)
        return reply


    ## case2: stop publish the 't/d' messages
    ##
    # def OnMessagePublish(self, request, context):
    #     print("OnMessagePublish:", request)
    #     nmsg = request.message
    #     if nmsg.topic == 't/banned_topic_by_exhook':
    #         nmsg.payload = b""
    #         nmsg.headers['allow_publish'] = b"false"

    #     reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", message=nmsg)
    #     return reply


    ## case3: stop publish the 't/d' messages
    ##        and republish a new message to 't/new' topic
    ##        to let rule engine to process it
    ##
    # def OnMessagePublish(self, request, context):
    #    print("OnMessagePublish:", request)
    #    nmsg = request.message
    #    if nmsg.topic == 't/raw_msg':
    #        nmsg.topic = 't/exhook_parsed'
    #        nmsg.payload = b"{\"mgs\": \"hardcode payload by exhook-svr-python :)\"}"
    #        # set to true to continue publish the message with 't/raw_msg'
    #        nmsg.headers['allow_publish'] = b"false"
    #        reply = exhook_pb2.ValuedResponse(type="STOP_AND_REPUBLISH", message=nmsg)
    #    else:
    #        reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", message=nmsg)
    #    return reply


    def OnMessageDelivered(self, request, context):
        print("OnMessageDelivered:", request)
        return exhook_pb2.EmptySuccess()

    def OnMessageDropped(self, request, context):
        print("OnMessageDropped:", request)
        return exhook_pb2.EmptySuccess()

    def OnMessageAcked(self, request, context):
        print("OnMessageAcked:", request)
        return exhook_pb2.EmptySuccess()

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    exhook_pb2_grpc.add_HookProviderServicer_to_server(HookProvider(), server)
    server.add_insecure_port('[::]:9000')
    server.start()

    print("Started gRPC server on [::]:9000")

    server.wait_for_termination()


if __name__ == '__main__':
    logging.basicConfig()
    serve()
