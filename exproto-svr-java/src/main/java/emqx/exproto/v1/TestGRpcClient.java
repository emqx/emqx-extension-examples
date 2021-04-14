package emqx.exproto.v1;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

class TestGRpcClient {

    public static void main(String[] args) throws Exception {
        String target = "127.0.0.1:9001";
        // 构建发布请求
        Exproto.PublishRequest request = Exproto.PublishRequest.newBuilder()
                .setTopic("/test")
                .setQos(0)
                .setPayload(ByteString.copyFromUtf8("hello")).build();
        // 认证信息
        Exproto.ClientInfo clientInfo = Exproto.ClientInfo.newBuilder()
                .setUsername("username1")
                .setClientid("clientid1")
                .build();
        Exproto.AuthenticateRequest authenticateRequest = Exproto.AuthenticateRequest.newBuilder()
                .setPassword("password1")
                .setClientinfo(clientInfo).build();
        // 构建连接通道
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .build();

        ConnectionAdapterGrpc.ConnectionAdapterBlockingStub blockingStub = ConnectionAdapterGrpc.newBlockingStub(channel);

        // 认证逻辑在 ConnectionAdapter.java
        Exproto.CodeResponse codeResponse = blockingStub.authenticate(authenticateRequest);
        System.out.println(codeResponse.getMessage());
        Exproto.CodeResponse response = blockingStub.publish(request);
        System.out.println("Response:" + response.getMessage());
    }
}