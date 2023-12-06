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
import inspect
from multiprocessing.sharedctypes import Value

import grpc

import exhook_pb2
import exhook_pb2_grpc

class HookProvider(exhook_pb2_grpc.HookProviderServicer):

    def OnProviderLoaded(self, request, context):
        print_req(request)
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
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnClientConnect(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnClientConnack(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnClientConnected(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnClientDisconnected(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnClientAuthenticate(self, request, context):
        print_req(request)
        reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", bool_result=True)
        return reply

    def OnClientAuthorize(self, request, context):
        print_req(request)
        reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", bool_result=True)
        return reply

    def OnClientSubscribe(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnClientUnsubscribe(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnSessionCreated(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnSessionSubscribed(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnSessionUnsubscribed(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnSessionResumed(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnSessionDiscarded(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnSessionTakenover(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnSessionTerminated(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnMessagePublish(self, request, context):
        print_req(request)
        nmsg = request.message
        nmsg.payload = b"hardcode payload by exhook-svr-python :)"

        reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", message=nmsg)
        return reply

    ## case2: stop publish the 't/d' messages
    ##
    #def OnMessagePublish(self, request, context):
    #    print_req(request)
    #    nmsg = request.message
    #    if nmsg.topic == 't/d':
    #        nmsg.payload = b""
    #        nmsg.headers['allow_publish'] = b"false"
    #
    #    reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", message=nmsg)
    #    return reply

    def OnMessageDelivered(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnMessageDropped(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

    def OnMessageAcked(self, request, context):
        print_req(request)
        return exhook_pb2.EmptySuccess()

def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    exhook_pb2_grpc.add_HookProviderServicer_to_server(HookProvider(), server)
    server.add_insecure_port('[::]:9000')
    server.start()

    print("Started gRPC server on [::]:9000")

    server.wait_for_termination()


def print_req(content):
    print("\033[1;32m\u2714 ", "\033[0m\033[1;32m==================\033[0m")
    print(highlight(inspect.currentframe().f_back.f_code.co_name))
    print(content)
    print("\n")

def highlight(content):
    if isinstance(content, str):
        content1 = content
    else:
        content1 = str(content)
    return "\033[0;33m" + content1 + "\033[0m"

if __name__ == '__main__':
    logging.basicConfig()
    serve()
