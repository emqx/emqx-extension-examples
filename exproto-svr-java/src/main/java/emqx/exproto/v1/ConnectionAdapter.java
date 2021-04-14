package emqx.exproto.v1;

import io.grpc.stub.StreamObserver;

/**
 * @author wangwenhai  2020/10/13
 * File description:
 */
public class ConnectionAdapter extends ConnectionAdapterGrpc.ConnectionAdapterImplBase {
    /**
     *  认证接口回调
     * @param request 请求
     * @param responseObserver 响应
     */
    @Override
    public void authenticate(Exproto.AuthenticateRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        System.out.println("--------------------- begin: authenticate");
        System.out.println("username"+request.getClientinfo().getUsername());
        System.out.println("clientid"+request.getClientinfo().getClientid());
        System.out.println("password"+request.getPassword());
        super.authenticate(request, responseObserver);
        System.out.println("--------------------- end: authenticate");

    }

    @Override
    public void send(Exproto.SendBytesRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        super.send(request, responseObserver);
    }

    @Override
    public void publish(Exproto.PublishRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        super.publish(request, responseObserver);
    }

    @Override
    public void close(Exproto.CloseSocketRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        super.close(request, responseObserver);
    }

    @Override
    public void startTimer(Exproto.TimerRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        super.startTimer(request, responseObserver);
    }

    @Override
    public void subscribe(Exproto.SubscribeRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        super.subscribe(request, responseObserver);
    }

    @Override
    public void unsubscribe(Exproto.UnsubscribeRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        super.unsubscribe(request, responseObserver);
    }
}
