/*
 * Copyright 2023 EMQ Technologies Co., Ltd. All Rights Reserved.
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

package io.emqx.exproto;

import emqx.exproto.v1.*;;
import emqx.exproto.v1.Exproto.*;;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.InsecureChannelCredentials;
import io.grpc.StatusRuntimeException;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExprotoServer
{
  private static final Logger logger = Logger.getLogger(ConnectionUnaryHandlerServer.class.getName());

  // gRPC server to listen on port 9001 for providing ConnectionUnaryHandler service
  private Server server;
  // gRPC client to request to ExProto Gateway ConnectionAdapter service
  private final ManagedChannel channel;

  public ExprotoServer(String target) {
    channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
  }

  private void start() throws IOException {
    /* The port on which the server should run */
    int port = 9001;
    server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
        .addService(new ConnectionUnaryHandlerServer(channel))
        .build()
        .start();
    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        try {
          ExprotoServer.this.stop();
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
    if (channel != null) {
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
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
    // Access a service running on the local machine on port 9100
    String target = "127.0.0.1:9100";
    // Start gRPC server
    final ExprotoServer server = new ExprotoServer(target);
    server.start();

    // Print hints
    System.out.println("Note: This demo server only works for emqx 5.1.0 or higher version.");
    System.out.println("      It will echo the received message back to the client");
    System.out.println("Note: Please make sure the ConnectionAdapter of ExProto gateway is");
    System.out.println("      running on " + target);
    System.out.println("");
    System.out.println("ConnectionUnaryHandler started successfully, listening on 9001");
    System.out.println("");
    System.out.println("Tips: If the Listener of EMQX ExProto gateway listen on 7993:");
    System.out.println("      You can use the telnet to test the server, for example:");
    System.out.println("");
    System.out.println("      telnet 127.0.0.1 7993");
    System.out.println("");
    System.out.println("Waiting for client connections...");

    server.blockUntilShutdown();
  }

  static class ConnectionUnaryHandlerServer extends ConnectionUnaryHandlerGrpc.ConnectionUnaryHandlerImplBase {

    private final ConnectionAdapterGrpc.ConnectionAdapterBlockingStub blockingStub;

    public ConnectionUnaryHandlerServer(Channel channel) {
        blockingStub = ConnectionAdapterGrpc.newBlockingStub(channel);
    }

    @Override
    public void onSocketCreated(SocketCreatedRequest request, StreamObserver<EmptySuccess> responseObserver) {
        logger.info("[callback] onSocketCreated, request: " + request.toString());

        // Using Authenticate to reigster your client to ExProto gateway
        //
        // Note1: If the clientid has been registered to ExProto gateway by other client, the old connection
        //        will be closed, due to the clientid is unique in ExProto gateway
        //
        // Note2: The username and password can be used to authenticate the client, if the username and password
        //        is not correct, the AuthenticateResponse.code will be set to 5 (PERMISSION_DENY)
        ClientInfo clientInfo = ClientInfo.newBuilder()
            .setClientid("test")
            .setUsername("test")
            .setProtoName("exproto-echo-svr")
            .setProtoVer("1.0")
            .build();
        AuthenticateRequest authReq = AuthenticateRequest
            .newBuilder()
            .setConn(request.getConn())
            .setClientinfo(clientInfo)
            .setPassword("password")
            .build();
        try {
          logger.info("[request ] Send AuthenticateRequest to register client to ExProto gateway, clientid=test");
          blockingStub.authenticate(authReq);
        } catch (StatusRuntimeException e) {
          logger.log(Level.WARNING, "[response] Authenticate RPC failed: {0}", e.getStatus());
          return;
        }
        logger.info("[response] Authenticate successfully");

        // Subscribe to topic test/echo for this connection
        SubscribeRequest subReq = SubscribeRequest
            .newBuilder()
            .setConn(request.getConn())
            .setTopic("test/echo")
            .setQos(1)
            .build();
        try {
          logger.info("[request ] Send SubscribeRequest to subscribe topic test/echo");
          blockingStub.subscribe(subReq);
        } catch (StatusRuntimeException e) {
          logger.log(Level.WARNING, "[response] Subscribe RPC failed: {0}", e.getStatus());
          return;
        }
        logger.info("[response] Subscribe successfully");

        // Optional, start the keepalive timer to check the clients' active status
        // If the client is inactive for 60 seconds, the callback function OnTimerTimeout
        // will be called
        TimerRequest timerReq = TimerRequest
            .newBuilder()
            .setConn(request.getConn())
            .setType(TimerType.KEEPALIVE)
            .setInterval(60)
            .build();
        try {
          logger.info("[request ] Send TimerRequest to start keepalive timer");
          blockingStub.startTimer(timerReq);
        } catch (StatusRuntimeException e) {
          logger.log(Level.WARNING, "[response] Timer RPC failed: {0}", e.getStatus());
          return;
        }
        logger.info("[response] Timer successfully");

        responseObserver.onNext(EmptySuccess.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void onSocketClosed(SocketClosedRequest request, StreamObserver<EmptySuccess> responseObserver) {
        logger.info("[callback] onSocketClosed, request: " + request.toString());
        responseObserver.onNext(EmptySuccess.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void onReceivedBytes(ReceivedBytesRequest request, StreamObserver<EmptySuccess> responseObserver) {
        logger.info("[callback] onReceivedBytes, request: " + request.toString());

        // Publish the received bytes to topic test/echo
        PublishRequest pubReq = PublishRequest
            .newBuilder()
            .setConn(request.getConn())
            .setTopic("test/echo")
            .setQos(1)
            .setPayload(request.getBytes())
            .build();
        try {
            logger.info("[request ] Send PublishRequest to publish received bytes to topic test/echo");
            blockingStub.publish(pubReq);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "[response] Publish RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("[response] Publish successfully");

        responseObserver.onNext(EmptySuccess.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void onTimerTimeout(TimerTimeoutRequest request, StreamObserver<EmptySuccess> responseObserver) {
        logger.info("[callback] onTimerTimeout, request: " + request.toString());
        // Close the inactive connection
        CloseSocketRequest closeReq = CloseSocketRequest
            .newBuilder()
            .setConn(request.getConn())
            .build();
        try {
            logger.info("[request ] Send CloseRequest to close inactive connection");
            blockingStub.close(closeReq);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "[response] Close RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("[response] Close successfully");

        responseObserver.onNext(EmptySuccess.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void onReceivedMessages(ReceivedMessagesRequest request, StreamObserver<EmptySuccess> responseObserver) {
        logger.info("[callback] onReceivedMessages, request: " + request.toString());

        // Send the received messages back to client
        for (Message msg : request.getMessagesList()) {
            SendBytesRequest sendReq = SendBytesRequest
                .newBuilder()
                .setConn(request.getConn())
                .setBytes(msg.getPayload())
                .build();
            try {
                logger.info("[request ] Send SendBytesRequest to deliver bytes of received message back to client");
                blockingStub.send(sendReq);
            } catch (StatusRuntimeException e) {
                logger.log(Level.WARNING, "[response] Send RPC failed: {0}", e.getStatus());
                return;
            }
            logger.info("[response] Send successfully");
        }

        responseObserver.onNext(EmptySuccess.newBuilder().build());
        responseObserver.onCompleted();
    }
  }
}
