/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.emqx.exhook;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class ExServer {
    private static final Logger logger = Logger.getLogger(ExServer.class.getName());

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 9000;

        server = ServerBuilder.forPort(port)
                .addService(new HookProviderImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    ExServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final ExServer server = new ExServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class HookProviderImpl extends HookProviderGrpc.HookProviderImplBase {

        public void DEBUG(String fn, Object req) {
            System.out.printf(fn + ", request: " + req);
        }

        @Override
        public void onProviderLoaded(ProviderLoadedRequest request, StreamObserver<LoadedResponse> responseObserver) {
            DEBUG("onProviderLoaded", request);
            HookSpec[] specs = {
                    HookSpec.newBuilder().setName("client.connect").build(),
                    HookSpec.newBuilder().setName("client.connack").build(),
                    HookSpec.newBuilder().setName("client.connected").build(),
                    HookSpec.newBuilder().setName("client.disconnected").build(),
                    HookSpec.newBuilder().setName("client.authenticate").build(),
                    HookSpec.newBuilder().setName("client.check_acl").build(),
                    HookSpec.newBuilder().setName("client.subscribe").build(),
                    HookSpec.newBuilder().setName("client.unsubscribe").build(),

                    HookSpec.newBuilder().setName("session.created").build(),
                    HookSpec.newBuilder().setName("session.subscribed").build(),
                    HookSpec.newBuilder().setName("session.unsubscribed").build(),
                    HookSpec.newBuilder().setName("session.resumed").build(),
                    HookSpec.newBuilder().setName("session.discarded").build(),
                    HookSpec.newBuilder().setName("session.takeovered").build(),
                    HookSpec.newBuilder().setName("session.terminated").build(),

                    HookSpec.newBuilder().setName("message.publish").build(),
                    HookSpec.newBuilder().setName("message.delivered").build(),
                    HookSpec.newBuilder().setName("message.acked").build(),
                    HookSpec.newBuilder().setName("message.dropped").build()
            };
            LoadedResponse reply = LoadedResponse.newBuilder().addAllHooks(Arrays.asList(specs)).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onProviderUnloaded(ProviderUnloadedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onProviderUnloaded", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onClientConnect(ClientConnectRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onClientConnect", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onClientConnack(ClientConnackRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onClientConnack", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onClientConnected(ClientConnectedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onClientConnected", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onClientDisconnected(ClientDisconnectedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onClientDisconnected", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onClientAuthenticate(ClientAuthenticateRequest request, StreamObserver<ValuedResponse> responseObserver) {
            DEBUG("onClientAuthenticate", request);
            ValuedResponse reply = ValuedResponse.newBuilder()
                                                 .setBoolResult(true)
                                                 .setType(ValuedResponse.ResponsedType.STOP_AND_RETURN)
                                                 .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onClientCheckAcl(ClientCheckAclRequest request, StreamObserver<ValuedResponse> responseObserver) {
            DEBUG("onClientCheckAcl", request);
            ValuedResponse reply = ValuedResponse.newBuilder()
                                                 .setBoolResult(true)
                                                 .setType(ValuedResponse.ResponsedType.STOP_AND_RETURN)
                                                 .build();

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onClientSubscribe(ClientSubscribeRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onClientSubscribe", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onClientUnsubscribe(ClientUnsubscribeRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onClientUnsubscribe", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onSessionCreated(SessionCreatedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onSessionCreated", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onSessionSubscribed(SessionSubscribedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onSessionSubscribed", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onSessionUnsubscribed(SessionUnsubscribedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onSessionUnsubscribed", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onSessionResumed(SessionResumedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onSessionResumed", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onSessionDiscarded(SessionDiscardedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onSessionDdiscarded", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onSessionTakeovered(SessionTakeoveredRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onSessionTakeovered", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onSessionTerminated(SessionTerminatedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onSessionTerminated", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onMessagePublish(MessagePublishRequest request, StreamObserver<ValuedResponse> responseObserver) {
            DEBUG("onMessagePublish", request);
            ValuedResponse reply = ValuedResponse.newBuilder().setMessage(request.getMessage()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onMessageDelivered(MessageDeliveredRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onMessageDelivered", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onMessageAcked(MessageAckedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onMessageAcked", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void onMessageDropped(MessageDroppedRequest request, StreamObserver<EmptySuccess> responseObserver) {
            DEBUG("onMessageDropped", request);
            EmptySuccess reply = EmptySuccess.newBuilder().build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
