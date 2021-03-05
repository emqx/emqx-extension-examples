package emqx.exproto.v1;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

class TestClient {

    public static void main(String[] args) throws Exception {
        String target = "127.0.0.1:9001";
        Exproto.PublishRequest request = Exproto.PublishRequest.newBuilder()
                .setTopic("/test")
                .setQos(0)
                .setPayload(ByteString.copyFromUtf8("hello")).build();
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .build();
        ConnectionAdapterGrpc.ConnectionAdapterBlockingStub blockingStub = ConnectionAdapterGrpc.newBlockingStub(channel);
        Exproto.CodeResponse response = blockingStub.publish(request);
        System.out.println("Response:" + response.getMessage());
    }
}