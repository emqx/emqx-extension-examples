package io.kp45.exhook;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.emqx.exhook.ClientAuthenticateRequest;
import io.emqx.exhook.EmptySuccess;
import io.emqx.exhook.HookProviderGrpc;
import io.emqx.exhook.HookSpec;
import io.emqx.exhook.LoadedResponse;
import io.emqx.exhook.ProviderLoadedRequest;
import io.emqx.exhook.ProviderUnloadedRequest;
import io.emqx.exhook.ValuedResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ExhookGrpcServer extends HookProviderGrpc.HookProviderImplBase {
    private static final Logger logger = LoggerFactory.getLogger(ExhookGrpcServer.class);

    @Autowired
    private Verifier verifier;

    @Override
    public void onProviderLoaded(ProviderLoadedRequest request, StreamObserver<LoadedResponse> responseObserver) {
        logger.info("onProviderLoaded", request);
        HookSpec[] specs = {
                HookSpec.newBuilder().setName("client.authenticate").build(),
        };
        LoadedResponse reply = LoadedResponse.newBuilder().addAllHooks(Arrays.asList(specs)).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void onProviderUnloaded(ProviderUnloadedRequest request, StreamObserver<EmptySuccess> responseObserver) {
        logger.info("onProviderUnloaded", request);
        EmptySuccess reply = EmptySuccess.newBuilder().build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void onClientAuthenticate(ClientAuthenticateRequest request,
            StreamObserver<ValuedResponse> responseObserver) {
        logger.info("onClientAuthenticate", request);
        boolean passed = verifier.verify(request.getClientinfo());
        ValuedResponse reply = ValuedResponse.newBuilder().setBoolResult(passed)
                .setType(ValuedResponse.ResponsedType.STOP_AND_RETURN).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
