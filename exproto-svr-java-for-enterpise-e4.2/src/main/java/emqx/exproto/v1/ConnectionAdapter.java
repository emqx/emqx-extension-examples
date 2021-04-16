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
        super.send(request, responseObserver);
    }

    @Override
    public void publish(Exproto.PublishRequest request, StreamObserver<Exproto.CodeResponse> responseObserver) {
        super.publish(request, responseObserver);
    }
}
