package emqx.exproto.v1;

import io.grpc.stub.StreamObserver;

/**
 * @author wangwenhai  2020/10/13
 * File description:
 */
public class ConnectionHandler extends ConnectionHandlerGrpc.ConnectionHandlerImplBase {
    @Override
    public void onSocketCreated(Exproto.SocketCreatedRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        Exproto.ConnInfo connInfo = request.getConninfo();
        // 只有IP 为 127.0.0.1才 让通过
        if (connInfo.getSockname().getHost().equals("127.0.0.1")) {
            System.out.println("[模拟数据库插入] 客户端上线:" + connInfo.toString());
            responseObserver.onNext(Exproto.EmptySuccess.getDefaultInstance());

            responseObserver.onCompleted();
        }
    }

    @Override
    public void onSocketClosed(Exproto.SocketClosedRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        System.out.println("[模拟数据库插入] 客户端离开线:" + request.getConn());
        responseObserver.onNext(Exproto.EmptySuccess.getDefaultInstance());
        responseObserver.onCompleted();

    }

    @Override
    public void onReceivedMessages(Exproto.ReceivedMessagesRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        responseObserver.onNext(Exproto.EmptySuccess.getDefaultInstance());
        responseObserver.onCompleted();

    }

    @Override
    public void onReceivedBytes(Exproto.ReceivedBytesRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        String data = request.getBytes().toStringUtf8();
        if (data.startsWith("[") && data.endsWith("]")) {
            String[] th = data.substring(1, data.length() - 1).split(",");
            System.out.println("收到数据,温度为" + th[0] + " 湿度" + th[1]);
        }
        responseObserver.onNext(Exproto.EmptySuccess.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void onTimerTimeout(Exproto.TimerTimeoutRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        System.out.println("连接超时");
        responseObserver.onNext(Exproto.EmptySuccess.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
