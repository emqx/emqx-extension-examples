package emqx.exproto.v1;

import io.grpc.stub.StreamObserver;

/**
 * @author wangwenhai
 * @date 2020/10/13
 * File description:
 */
public class ConnectionAdapter extends ConnectionAdapterGrpc.ConnectionAdapterImplBase {
    @Override
    public void send(Exproto.SendBytesRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        System.out.println("[LOG] send");
        responseObserver.onNext(Exproto.CodeResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void close(Exproto.CloseSocketRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        System.out.println("[LOG] close");

        super.close(request, responseObserver);
    }

    @Override
    public void authenticate(Exproto.AuthenticateRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        System.out.println("[LOG] authenticate");

        responseObserver.onNext(Exproto.CodeResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void startTimer(Exproto.TimerRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        System.out.println("[LOG] startTimer");

        responseObserver.onNext(Exproto.CodeResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void publish(Exproto.PublishRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        System.out.println("[LOG] publish");

        responseObserver.onNext(Exproto.CodeResponse.newBuilder().buildPartial());
        responseObserver.onCompleted();
    }

    @Override
    public void subscribe(Exproto.SubscribeRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        System.out.println("[LOG] subscribe");

        responseObserver.onNext(Exproto.CodeResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }

    @Override
    public void unsubscribe(Exproto.UnsubscribeRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        System.out.println("[LOG] unsubscribe");

        responseObserver.onNext(Exproto.CodeResponse.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
