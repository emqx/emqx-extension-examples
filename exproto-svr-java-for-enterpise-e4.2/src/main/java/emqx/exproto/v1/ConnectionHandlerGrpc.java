package emqx.exproto.v1;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: exproto.proto")
public final class ConnectionHandlerGrpc {

  private ConnectionHandlerGrpc() {}

  public static final String SERVICE_NAME = "emqx.exproto.v1.ConnectionHandler";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.SocketCreatedRequest,
      emqx.exproto.v1.Exproto.EmptySuccess> METHOD_ON_SOCKET_CREATED =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.SocketCreatedRequest, emqx.exproto.v1.Exproto.EmptySuccess>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionHandler", "OnSocketCreated"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.SocketCreatedRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.EmptySuccess.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.SocketClosedRequest,
      emqx.exproto.v1.Exproto.EmptySuccess> METHOD_ON_SOCKET_CLOSED =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.SocketClosedRequest, emqx.exproto.v1.Exproto.EmptySuccess>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionHandler", "OnSocketClosed"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.SocketClosedRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.EmptySuccess.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.ReceivedBytesRequest,
      emqx.exproto.v1.Exproto.EmptySuccess> METHOD_ON_RECEIVED_BYTES =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.ReceivedBytesRequest, emqx.exproto.v1.Exproto.EmptySuccess>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionHandler", "OnReceivedBytes"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.ReceivedBytesRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.EmptySuccess.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.TimerTimeoutRequest,
      emqx.exproto.v1.Exproto.EmptySuccess> METHOD_ON_TIMER_TIMEOUT =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.TimerTimeoutRequest, emqx.exproto.v1.Exproto.EmptySuccess>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionHandler", "OnTimerTimeout"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.TimerTimeoutRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.EmptySuccess.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.ReceivedMessagesRequest,
      emqx.exproto.v1.Exproto.EmptySuccess> METHOD_ON_RECEIVED_MESSAGES =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.ReceivedMessagesRequest, emqx.exproto.v1.Exproto.EmptySuccess>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionHandler", "OnReceivedMessages"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.ReceivedMessagesRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.EmptySuccess.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConnectionHandlerStub newStub(io.grpc.Channel channel) {
    return new ConnectionHandlerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConnectionHandlerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ConnectionHandlerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConnectionHandlerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ConnectionHandlerFutureStub(channel);
  }

  /**
   */
  public static abstract class ConnectionHandlerImplBase implements io.grpc.BindableService {

    /**
     */
    public void onSocketCreated(emqx.exproto.v1.Exproto.SocketCreatedRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ON_SOCKET_CREATED, responseObserver);
    }

    /**
     */
    public void onSocketClosed(emqx.exproto.v1.Exproto.SocketClosedRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ON_SOCKET_CLOSED, responseObserver);
    }

    /**
     */
    public void onReceivedBytes(emqx.exproto.v1.Exproto.ReceivedBytesRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ON_RECEIVED_BYTES, responseObserver);
    }

    /**
     */
    public void onTimerTimeout(emqx.exproto.v1.Exproto.TimerTimeoutRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ON_TIMER_TIMEOUT, responseObserver);
    }

    /**
     */
    public void onReceivedMessages(emqx.exproto.v1.Exproto.ReceivedMessagesRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ON_RECEIVED_MESSAGES, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ON_SOCKET_CREATED,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.SocketCreatedRequest,
                emqx.exproto.v1.Exproto.EmptySuccess>(
                  this, METHODID_ON_SOCKET_CREATED)))
          .addMethod(
            METHOD_ON_SOCKET_CLOSED,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.SocketClosedRequest,
                emqx.exproto.v1.Exproto.EmptySuccess>(
                  this, METHODID_ON_SOCKET_CLOSED)))
          .addMethod(
            METHOD_ON_RECEIVED_BYTES,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.ReceivedBytesRequest,
                emqx.exproto.v1.Exproto.EmptySuccess>(
                  this, METHODID_ON_RECEIVED_BYTES)))
          .addMethod(
            METHOD_ON_TIMER_TIMEOUT,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.TimerTimeoutRequest,
                emqx.exproto.v1.Exproto.EmptySuccess>(
                  this, METHODID_ON_TIMER_TIMEOUT)))
          .addMethod(
            METHOD_ON_RECEIVED_MESSAGES,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.ReceivedMessagesRequest,
                emqx.exproto.v1.Exproto.EmptySuccess>(
                  this, METHODID_ON_RECEIVED_MESSAGES)))
          .build();
    }
  }

  /**
   */
  public static final class ConnectionHandlerStub extends io.grpc.stub.AbstractStub<ConnectionHandlerStub> {
    private ConnectionHandlerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectionHandlerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionHandlerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectionHandlerStub(channel, callOptions);
    }

    /**
     */
    public void onSocketCreated(emqx.exproto.v1.Exproto.SocketCreatedRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ON_SOCKET_CREATED, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSocketClosed(emqx.exproto.v1.Exproto.SocketClosedRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ON_SOCKET_CLOSED, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onReceivedBytes(emqx.exproto.v1.Exproto.ReceivedBytesRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ON_RECEIVED_BYTES, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onTimerTimeout(emqx.exproto.v1.Exproto.TimerTimeoutRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ON_TIMER_TIMEOUT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onReceivedMessages(emqx.exproto.v1.Exproto.ReceivedMessagesRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ON_RECEIVED_MESSAGES, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ConnectionHandlerBlockingStub extends io.grpc.stub.AbstractStub<ConnectionHandlerBlockingStub> {
    private ConnectionHandlerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectionHandlerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionHandlerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectionHandlerBlockingStub(channel, callOptions);
    }

    /**
     */
    public emqx.exproto.v1.Exproto.EmptySuccess onSocketCreated(emqx.exproto.v1.Exproto.SocketCreatedRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ON_SOCKET_CREATED, getCallOptions(), request);
    }

    /**
     */
    public emqx.exproto.v1.Exproto.EmptySuccess onSocketClosed(emqx.exproto.v1.Exproto.SocketClosedRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ON_SOCKET_CLOSED, getCallOptions(), request);
    }

    /**
     */
    public emqx.exproto.v1.Exproto.EmptySuccess onReceivedBytes(emqx.exproto.v1.Exproto.ReceivedBytesRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ON_RECEIVED_BYTES, getCallOptions(), request);
    }

    /**
     */
    public emqx.exproto.v1.Exproto.EmptySuccess onTimerTimeout(emqx.exproto.v1.Exproto.TimerTimeoutRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ON_TIMER_TIMEOUT, getCallOptions(), request);
    }

    /**
     */
    public emqx.exproto.v1.Exproto.EmptySuccess onReceivedMessages(emqx.exproto.v1.Exproto.ReceivedMessagesRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ON_RECEIVED_MESSAGES, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ConnectionHandlerFutureStub extends io.grpc.stub.AbstractStub<ConnectionHandlerFutureStub> {
    private ConnectionHandlerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectionHandlerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionHandlerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectionHandlerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.EmptySuccess> onSocketCreated(
        emqx.exproto.v1.Exproto.SocketCreatedRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ON_SOCKET_CREATED, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.EmptySuccess> onSocketClosed(
        emqx.exproto.v1.Exproto.SocketClosedRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ON_SOCKET_CLOSED, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.EmptySuccess> onReceivedBytes(
        emqx.exproto.v1.Exproto.ReceivedBytesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ON_RECEIVED_BYTES, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.EmptySuccess> onTimerTimeout(
        emqx.exproto.v1.Exproto.TimerTimeoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ON_TIMER_TIMEOUT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.EmptySuccess> onReceivedMessages(
        emqx.exproto.v1.Exproto.ReceivedMessagesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ON_RECEIVED_MESSAGES, getCallOptions()), request);
    }
  }

  private static final int METHODID_ON_SOCKET_CREATED = 0;
  private static final int METHODID_ON_SOCKET_CLOSED = 1;
  private static final int METHODID_ON_RECEIVED_BYTES = 2;
  private static final int METHODID_ON_TIMER_TIMEOUT = 3;
  private static final int METHODID_ON_RECEIVED_MESSAGES = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConnectionHandlerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConnectionHandlerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ON_SOCKET_CREATED:
          serviceImpl.onSocketCreated((emqx.exproto.v1.Exproto.SocketCreatedRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SOCKET_CLOSED:
          serviceImpl.onSocketClosed((emqx.exproto.v1.Exproto.SocketClosedRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_RECEIVED_BYTES:
          serviceImpl.onReceivedBytes((emqx.exproto.v1.Exproto.ReceivedBytesRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_TIMER_TIMEOUT:
          serviceImpl.onTimerTimeout((emqx.exproto.v1.Exproto.TimerTimeoutRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_RECEIVED_MESSAGES:
          serviceImpl.onReceivedMessages((emqx.exproto.v1.Exproto.ReceivedMessagesRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.EmptySuccess>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ConnectionHandlerDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return emqx.exproto.v1.Exproto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConnectionHandlerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConnectionHandlerDescriptorSupplier())
              .addMethod(METHOD_ON_SOCKET_CREATED)
              .addMethod(METHOD_ON_SOCKET_CLOSED)
              .addMethod(METHOD_ON_RECEIVED_BYTES)
              .addMethod(METHOD_ON_TIMER_TIMEOUT)
              .addMethod(METHOD_ON_RECEIVED_MESSAGES)
              .build();
        }
      }
    }
    return result;
  }
}
