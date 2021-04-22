package emqx.exproto.v1;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

class TestGrpcClient {

    public static void main(String[] args) throws Exception {
        String target = "127.0.0.1:9100";
        Exproto.PublishRequest publishRequest = Exproto.PublishRequest.newBuilder()
                .setTopic("/test")
                .setQos(0)
                .setPayload(ByteString.copyFromUtf8("hello")).build();
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        ConnectionAdapterGrpc.ConnectionAdapterFutureStub futureStub = ConnectionAdapterGrpc.newFutureStub(channel);
        Exproto.CodeResponse response = futureStub.publish(publishRequest).get();
        System.out.println("Response:" + response.getMessage());
    }
}