# Copyright 2023 EMQ Technologies Co., Ltd. All Rights Reserved.
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
"""The Python implementation of the ExProto server."""

from concurrent import futures
import logging

import grpc
import exproto_pb2
import exproto_pb2_grpc

class ExProtoConnectionUnaryHandler(exproto_pb2_grpc.ConnectionUnaryHandlerServicer):

    ## Replace the IP address with your ConnectionAdapter server address in exproto gateway
    channel = grpc.insecure_channel('127.0.0.1:9100')

    stub = exproto_pb2_grpc.ConnectionAdapterStub(channel)

    def OnSocketCreated(self, request, context):
        print("OnSocketCreated: %s" % request)

        # Using Authenticate to reigster your client to EMQX
        info = exproto_pb2.ClientInfo(clientid="test", username="test", proto_name="exproto-echo-svr", proto_ver="1")
        auth = exproto_pb2.AuthenticateRequest(clientinfo=info, password="password", conn=request.conn)
        auth_response = self.stub.Authenticate(auth)
        print("Authenticate response: %s" % str(auth_response.code))

        # Subscribe to topic t/a for this connection
        subscribe = exproto_pb2.SubscribeRequest(conn=request.conn, topic="test/echo", qos=1)
        sub_response = self.stub.Subscribe(subscribe)
        print("Subscribe response: %s" % str(sub_response.code))

        # Optional, start the keepalive timer to check the clients' active status
        # If the client is inactive for 60 seconds, the callback function OnTimerTimeout
        # will be called
        timer = exproto_pb2.TimerRequest(conn=request.conn, type=exproto_pb2.TimerType.KEEPALIVE, interval=60)
        timer_response = self.stub.StartTimer(timer)
        print("StartTimer response: %s" % str(timer_response.code))

        return exproto_pb2.EmptySuccess()

    def OnSocketClosed(self, request, context):
        print("OnSocketClosed: %s" % request)
        return exproto_pb2.EmptySuccess()

    def OnReceivedBytes(self, request, context):
        print("OnReceivedBytes: %s" % request)

        # Publish the received bytes to topic test/echo
        publish = exproto_pb2.PublishRequest(conn=request.conn, topic="test/echo", payload=request.bytes, qos=1)
        response = self.stub.Publish(publish)
        print("Publish response: %s" % str(response.code))

        return exproto_pb2.EmptySuccess()

    def OnTimerTimeout(self, request, context):
        print("OnTimerTimeout: %s" % request)
        # Close the inactive connection
        close = exproto_pb2.CloseSocketRequest(conn=request.conn)
        response = self.stub.Close(close)
        print("Close response: %s" % str(response.code))
        return exproto_pb2.EmptySuccess()

    def OnReceivedMessages(self, request, context):
        print("OnReceivedMessages: %s" % request)

        # Send the received message back to the client
        message = request.messages[0]
        send = exproto_pb2.SendBytesRequest(conn=request.conn, bytes=message.payload)
        response = self.stub.Send(send)
        print("Send response: %s" % str(response.code))

        return exproto_pb2.EmptySuccess()

def serve():
    port = '9001'
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    exproto_pb2_grpc.add_ConnectionUnaryHandlerServicer_to_server(ExProtoConnectionUnaryHandler(), server)
    server.add_insecure_port('[::]:' + port)
    server.start()
    print("Server started, listening on " + port)
    server.wait_for_termination()

if __name__ == '__main__':
    logging.basicConfig()
    serve()
