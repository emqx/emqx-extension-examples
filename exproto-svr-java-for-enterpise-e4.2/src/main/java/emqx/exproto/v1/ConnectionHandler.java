package emqx.exproto.v1;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @author wangwenhai
 * @date 2020/10/13
 * File description:
 */
public class ConnectionHandler extends ConnectionHandlerGrpc.ConnectionHandlerImplBase {
    @Override
    public void onSocketCreated(Exproto.SocketCreatedRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        System.out.println("[LOG] 客户端 SOCKET 连接:" + request.getConninfo());
        String target = "127.0.0.1:9100";

        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
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
        System.out.println("Response:" + response.getMessage());

        responseObserver.onNext(Exproto.EmptySuccess.newBuilder().build());
        responseObserver.onCompleted();

    }

    @Override
    public void onSocketClosed(Exproto.SocketClosedRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        System.out.println("[LOG] 客户端离开线:" + request.toString());
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
        responseObserver.onNext(Exproto.EmptySuccess.newBuilder().build());
        Exproto.PublishRequest publishRequest = Exproto.PublishRequest.newBuilder()
                .setConn(request.getConn())
                .setTopic("/test")
                .setQos(0)
                .setPayload(ByteString.copyFromUtf8(request.getBytes().toStringUtf8())).build();
        ManagedChannel channel = NettyChannelBuilder.forAddress("127.0.0.1", 9100)
                .negotiationType(NegotiationType.PLAINTEXT)
                .usePlaintext()
                .build();
        ConnectionAdapterGrpc.ConnectionAdapterBlockingStub blockingStub = ConnectionAdapterGrpc.newBlockingStub(channel);
        try {
            Exproto.CodeResponse response = blockingStub.publish(publishRequest);
            System.out.println("Response:" + response.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
        responseObserver.onNext(Exproto.EmptySuccess.newBuilder().build());

        responseObserver.onCompleted();


    }

    @Override
    public void onTimerTimeout(Exproto.TimerTimeoutRequest request, StreamObserver<Exproto.EmptySuccess> responseObserver) {
        System.out.println("连接超时");
        responseObserver.onNext(Exproto.EmptySuccess.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
