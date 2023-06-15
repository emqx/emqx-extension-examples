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

import grpc
import exproto_pb2
import exproto_pb2_grpc


## Replace the IP address with your ConnectionAdapter server address in exproto gateway
connection_adapter_addr = '127.0.0.1:9100'

class ExProtoConnectionUnaryHandler(exproto_pb2_grpc.ConnectionUnaryHandlerServicer):

    channel = grpc.insecure_channel(connection_adapter_addr)

    stub = exproto_pb2_grpc.ConnectionAdapterStub(channel)

    def OnSocketCreated(self, request, context):
        print("[callback] OnSocketCreated: %s" % request)

        # Using Authenticate to reigster your client to ExProto gateway
        #
        # Note1: If the clientid has been registered to ExProto gateway by other client, the old connection
        #        will be closed, due to the clientid is unique in ExProto gateway
        #
        # Note2: The username and password can be used to authenticate the client, if the username and password
        #        is not correct, the AuthenticateResponse.code will be set to 5 (PERMISSION_DENY)
        print("[request ] Send AuthenticateRequest to reigster client to ExProto gateway: clientid=test")
        info = exproto_pb2.ClientInfo(clientid="test", username="test", proto_name="exproto-echo-svr", proto_ver="1")
        auth = exproto_pb2.AuthenticateRequest(clientinfo=info, password="password", conn=request.conn)
        auth_response = self.stub.Authenticate(auth)
        print("[response] Authenticate response: %s" % str(auth_response.code))

        # Subscribe to topic t/a for this connection
        print("[request ] Send SubscribeRequest to subscribe topic test/echo")
        subscribe = exproto_pb2.SubscribeRequest(conn=request.conn, topic="test/echo", qos=1)
        sub_response = self.stub.Subscribe(subscribe)
        print("[response] Subscribe response: %s" % str(sub_response.code))

        # Optional, start the keepalive timer to check the clients' active status
        # If the client is inactive for 60 seconds, the callback function OnTimerTimeout
        # will be called
        print("[request ] Send TimerRequest to start keepalive timer in 60 seconds")
        timer = exproto_pb2.TimerRequest(conn=request.conn, type=exproto_pb2.TimerType.KEEPALIVE, interval=60)
        timer_response = self.stub.StartTimer(timer)
        print("[response] StartTimer response: %s" % str(timer_response.code))

        return exproto_pb2.EmptySuccess()

    def OnSocketClosed(self, request, context):
        print("[callback] OnSocketClosed: %s" % request)
        return exproto_pb2.EmptySuccess()

    def OnReceivedBytes(self, request, context):
        print("[callback] OnReceivedBytes: %s" % request)

        # Publish the received bytes to topic test/echo
        print("[request ] Send PublishRequest to publish the received bytes to topic test/echo")
        publish = exproto_pb2.PublishRequest(conn=request.conn, topic="test/echo", payload=request.bytes, qos=1)
        response = self.stub.Publish(publish)
        print("[response] Publish response: %s" % str(response.code))

        return exproto_pb2.EmptySuccess()

    def OnTimerTimeout(self, request, context):
        print("[callback] OnTimerTimeout: %s" % request)
        # Close the inactive connection
        print("[request ] Send CloseSocketRequest to close the inactive connection")
        close = exproto_pb2.CloseSocketRequest(conn=request.conn)
        response = self.stub.Close(close)
        print("[response] Close response: %s" % str(response.code))
        return exproto_pb2.EmptySuccess()

    def OnReceivedMessages(self, request, context):
        print("[callback] OnReceivedMessages: %s" % request)

        # Send the received message back to the client
        print("[request ] Send SendBytesRequest to deliver bytes of message to client")
        message = request.messages[0]
        send = exproto_pb2.SendBytesRequest(conn=request.conn, bytes=message.payload)
        response = self.stub.Send(send)
        print("[response] Send response: %s" % str(response.code))

        return exproto_pb2.EmptySuccess()

def serve():
    port = '9001'
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    exproto_pb2_grpc.add_ConnectionUnaryHandlerServicer_to_server(ExProtoConnectionUnaryHandler(), server)
    server.add_insecure_port('[::]:' + port)
    server.start()
    print("Note: This demo server only works for emqx 5.1.0 or higher version.")
    print("      It will echo the received message back to the client")
    print("Note: Please make sure the ConnectionAdapter of ExProto gateway is")
    print("      running on " + connection_adapter_addr)
    print("")
    print("ConnectionUnaryHandler started successfully, listening on " + port)
    print("")
    print("Tips: If the Listener of EMQX ExProto gateway listen on 7993:")
    print("      You can use the telnet to test the server, for example:")
    print("")
    print("      telnet 127.0.0.1 7993")
    print("")
    print("Waiting for client connections...")
    server.wait_for_termination()

if __name__ == '__main__':
    serve()
