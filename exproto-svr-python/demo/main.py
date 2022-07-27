# author：wangscaler
# date: 2021.07.14 19:03
from concurrent import futures
import logging
import grpc
import exproto_pb2
import exproto_pb2_grpc

logging.getLogger().setLevel(logging.INFO)


class ConnectionHandlerServicer(exproto_pb2_grpc.ConnectionHandlerServicer):
    # 这里替换成你的EMQX的IP地址
    channel = grpc.insecure_channel('127.0.0.1:9100')
    stub = exproto_pb2_grpc.ConnectionAdapterStub(channel)

    def OnSocketCreated(self, request_iterator, context):
        for request in request_iterator:
            logging.info("[LOG] 客户端 SOCKET 连接: ")
            logging.info(request)
            # EMQX认证
            username = password = str(request.conninfo.peername.port)
            logging.info(request.conninfo.peername.port)
            info = exproto_pb2.ClientInfo(username=username, clientid=password)
            auth = exproto_pb2.AuthenticateRequest(clientinfo=info, password="test", conn=request.conn)
            auth_response = self.stub.Authenticate(auth)
            logging.info("[LOG] authenticate code: " + str(auth_response.code))
            # 订阅主题
            subscribe = exproto_pb2.SubscribeRequest(conn=request.conn, qos=1, topic="/test")
            sub_response = self.stub.Subscribe(subscribe)
            logging.info("[LOG] subscribe code: " + str(sub_response.code))
            # 启动心跳检测interval*3s
            timer = exproto_pb2.TimerRequest(conn=request.conn, type=exproto_pb2.TimerType.KEEPALIVE, interval=30)
            timer_response = self.stub.StartTimer(timer)
            logging.info("[LOG] Timer code: " + str(timer_response.code))
        return exproto_pb2.SocketCreatedRequest()

    def OnReceivedBytes(self, request_iterator, context):
        # 将tcp连接发送的数据发布
        for request in request_iterator:
            # data = request.bytes.decode('utf-8')
            # logging.info("[LOG] ReceivedBytesRequest：" + data)
            # 发布消息
            publish = exproto_pb2.PublishRequest(conn=request.conn, topic="/test1", qos=1, payload=request.bytes)
            response = self.stub.Publish(publish)
            logging.info("[LOG] publish code: " + str(response.code))
        return exproto_pb2.ReceivedBytesRequest()

    def OnSocketClosed(self, request_iterator, context):
        for request in request_iterator:
            logging.info("[LOG] onSocketClosed:")
            logging.info(request)
        return exproto_pb2.SocketCreatedRequest()

    def OnTimerTimeout(self, request_iterator, context):
        for request in request_iterator:
            logging.info("[LOG] OnTimerTimeout:")
            logging.info(request)
            # 关闭心跳超时的连接
            # close = exproto_pb2.TimerTimeoutRequest(conn=request.conn, type=exproto_pb2.TimerType.KEEPALIVE)
            close = exproto_pb2.CloseSocketRequest(conn=request.conn)
            response = self.stub.Close(close)
            logging.info("[LOG] close:" + str(response.code))
        return exproto_pb2.TimerTimeoutRequest()

    def OnReceivedMessages(self, request_iterator, context):
        # 将EMQX收到的消息发送
        for request in request_iterator:
            logging.info("[LOG] OnReceivedMessages:")
            logging.info(request)
            message = request.messages[0]
            send = exproto_pb2.SendBytesRequest(conn=request.conn, bytes=message.payload)
            response = self.stub.Send(send)
            logging.info("[LOG] sendbytes:" + str(response.code))
        return exproto_pb2.ReceivedMessagesRequest()


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    exproto_pb2_grpc.add_ConnectionHandlerServicer_to_server(
        ConnectionHandlerServicer(), server)
    server.add_insecure_port('[::]:9001')
    server.start()
    server.wait_for_termination()


if __name__ == '__main__':
    logging.basicConfig()
    serve()
