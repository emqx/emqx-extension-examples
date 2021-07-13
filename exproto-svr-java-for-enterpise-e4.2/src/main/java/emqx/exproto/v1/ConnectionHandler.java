package emqx.exproto.v1;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @author wangwenhai
 * @date 2020/10/13
 * File description:
 */
public class ConnectionHandler extends ConnectionHandlerGrpc.ConnectionHandlerImplBase {
    private static final String HOST = "127.0.0.1:9100";
    static ManagedChannel channel;

    static {
        System.out.println("[LOG] Build singleton channel");
        channel = ManagedChannelBuilder.forTarget(HOST)
                .usePlaintext()
                .build();
    }

    @Override
    public void onSocketCreated(Exproto.SocketCreatedRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        System.out.println("[LOG] 客户端 SOCKET 连接:" + request.getConninfo());
        Exproto.ClientInfo clientInfo = Exproto.ClientInfo.newBuilder()
                .setClientid("c1")
                .setUsername("demo")
                .build();
        Exproto.AuthenticateRequest authenticateRequest = Exproto.AuthenticateRequest.newBuilder()
                .setClientinfo(clientInfo)
                .setConn(request.getConn())
                .setPassword("password")
                .build();

        ConnectionAdapterGrpc.ConnectionAdapterBlockingStub blockingStub = ConnectionAdapterGrpc.newBlockingStub(channel);
        Exproto.CodeResponse response = blockingStub.authenticate(authenticateRequest);
        System.out.println("[LOG] authenticate" + response.getMessageBytes());
        responseObserver.onNext(Exproto.EmptySuccess.newBuilder().build());
        responseObserver.onCompleted();

    }

    @Override
    public void onSocketClosed(Exproto.SocketClosedRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        System.out.println("[LOG] onSocketClosed:" + request.toString());
        responseObserver.onNext(Exproto.EmptySuccess.getDefaultInstance());
        responseObserver.onCompleted();

    }

    @Override
    public void onReceivedMessages(Exproto.ReceivedMessagesRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        System.out.println("[LOG] onReceivedMessages：" + request.getConn());
        responseObserver.onNext(Exproto.EmptySuccess.getDefaultInstance());
        responseObserver.onCompleted();

    }

    @Override
    public void onReceivedBytes(Exproto.ReceivedBytesRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        System.out.println("[LOG] ReceivedBytesRequest：" + request.getConn());
        Exproto.PublishRequest publishRequest = Exproto.PublishRequest.newBuilder()
                .setConn(request.getConn())
                .setTopic("/test")
                .setQos(0)
                .setPayload(ByteString.copyFromUtf8(request.getBytes().toStringUtf8())).build();

        ConnectionAdapterGrpc.ConnectionAdapterBlockingStub blockingStub = ConnectionAdapterGrpc.newBlockingStub(channel);
        Exproto.CodeResponse response = blockingStub.publish(publishRequest);
        System.out.println("[LOG] onReceivedBytes" + response.getMessage());
        responseObserver.onNext(Exproto.EmptySuccess.newBuilder().build());
        responseObserver.onCompleted();


    }

    @Override
    public void onTimerTimeout(Exproto.TimerTimeoutRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        System.out.println("[LOG] onTimerTimeout");
        responseObserver.onNext(Exproto.EmptySuccess.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
