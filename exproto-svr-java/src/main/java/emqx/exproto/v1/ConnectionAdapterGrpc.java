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
 * <pre>
 * The Broker side serivce. It provides a set of APIs to
 * handle a protcol access
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: exproto.proto")
public final class ConnectionAdapterGrpc {

  private ConnectionAdapterGrpc() {}

  public static final String SERVICE_NAME = "emqx.exproto.v1.ConnectionAdapter";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.SendBytesRequest,
      emqx.exproto.v1.Exproto.CodeResponse> METHOD_SEND =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.SendBytesRequest, emqx.exproto.v1.Exproto.CodeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionAdapter", "Send"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.SendBytesRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.CodeResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.CloseSocketRequest,
      emqx.exproto.v1.Exproto.CodeResponse> METHOD_CLOSE =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.CloseSocketRequest, emqx.exproto.v1.Exproto.CodeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionAdapter", "Close"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.CloseSocketRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.CodeResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.AuthenticateRequest,
      emqx.exproto.v1.Exproto.CodeResponse> METHOD_AUTHENTICATE =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.AuthenticateRequest, emqx.exproto.v1.Exproto.CodeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionAdapter", "Authenticate"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.AuthenticateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.CodeResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.TimerRequest,
      emqx.exproto.v1.Exproto.CodeResponse> METHOD_START_TIMER =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.TimerRequest, emqx.exproto.v1.Exproto.CodeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionAdapter", "StartTimer"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.TimerRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.CodeResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.PublishRequest,
      emqx.exproto.v1.Exproto.CodeResponse> METHOD_PUBLISH =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.PublishRequest, emqx.exproto.v1.Exproto.CodeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionAdapter", "Publish"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.PublishRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.CodeResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.SubscribeRequest,
      emqx.exproto.v1.Exproto.CodeResponse> METHOD_SUBSCRIBE =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.SubscribeRequest, emqx.exproto.v1.Exproto.CodeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionAdapter", "Subscribe"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.SubscribeRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.CodeResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<emqx.exproto.v1.Exproto.UnsubscribeRequest,
      emqx.exproto.v1.Exproto.CodeResponse> METHOD_UNSUBSCRIBE =
      io.grpc.MethodDescriptor.<emqx.exproto.v1.Exproto.UnsubscribeRequest, emqx.exproto.v1.Exproto.CodeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "emqx.exproto.v1.ConnectionAdapter", "Unsubscribe"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.UnsubscribeRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              emqx.exproto.v1.Exproto.CodeResponse.getDefaultInstance()))
          .build();


  public static ConnectionAdapterStub newStub(io.grpc.Channel channel) {
    return new ConnectionAdapterStub(channel);
  }

  public static ConnectionAdapterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ConnectionAdapterBlockingStub(channel);
  }

  public static ConnectionAdapterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ConnectionAdapterFutureStub(channel);
  }

  public static abstract class ConnectionAdapterImplBase implements io.grpc.BindableService {


    public void send(emqx.exproto.v1.Exproto.SendBytesRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND, responseObserver);
    }


    public void close(emqx.exproto.v1.Exproto.CloseSocketRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CLOSE, responseObserver);
    }


    public void authenticate(emqx.exproto.v1.Exproto.AuthenticateRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_AUTHENTICATE, responseObserver);
    }


    public void startTimer(emqx.exproto.v1.Exproto.TimerRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_START_TIMER, responseObserver);
    }


    public void publish(emqx.exproto.v1.Exproto.PublishRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PUBLISH, responseObserver);
    }


    public void subscribe(emqx.exproto.v1.Exproto.SubscribeRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SUBSCRIBE, responseObserver);
    }


    public void unsubscribe(emqx.exproto.v1.Exproto.UnsubscribeRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UNSUBSCRIBE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEND,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.SendBytesRequest,
                emqx.exproto.v1.Exproto.CodeResponse>(
                  this, METHODID_SEND)))
          .addMethod(
            METHOD_CLOSE,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.CloseSocketRequest,
                emqx.exproto.v1.Exproto.CodeResponse>(
                  this, METHODID_CLOSE)))
          .addMethod(
            METHOD_AUTHENTICATE,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.AuthenticateRequest,
                emqx.exproto.v1.Exproto.CodeResponse>(
                  this, METHODID_AUTHENTICATE)))
          .addMethod(
            METHOD_START_TIMER,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.TimerRequest,
                emqx.exproto.v1.Exproto.CodeResponse>(
                  this, METHODID_START_TIMER)))
          .addMethod(
            METHOD_PUBLISH,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.PublishRequest,
                emqx.exproto.v1.Exproto.CodeResponse>(
                  this, METHODID_PUBLISH)))
          .addMethod(
            METHOD_SUBSCRIBE,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.SubscribeRequest,
                emqx.exproto.v1.Exproto.CodeResponse>(
                  this, METHODID_SUBSCRIBE)))
          .addMethod(
            METHOD_UNSUBSCRIBE,
            asyncUnaryCall(
              new MethodHandlers<
                emqx.exproto.v1.Exproto.UnsubscribeRequest,
                emqx.exproto.v1.Exproto.CodeResponse>(
                  this, METHODID_UNSUBSCRIBE)))
          .build();
    }
  }

  /**
   * <pre>
   * The Broker side serivce. It provides a set of APIs to
   * handle a protcol access
   * </pre>
   */
  public static final class ConnectionAdapterStub extends io.grpc.stub.AbstractStub<ConnectionAdapterStub> {
    private ConnectionAdapterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectionAdapterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionAdapterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectionAdapterStub(channel, callOptions);
    }


    public void send(emqx.exproto.v1.Exproto.SendBytesRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND, getCallOptions()), request, responseObserver);
    }


    public void close(emqx.exproto.v1.Exproto.CloseSocketRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CLOSE, getCallOptions()), request, responseObserver);
    }


    public void authenticate(emqx.exproto.v1.Exproto.AuthenticateRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTHENTICATE, getCallOptions()), request, responseObserver);
    }


    public void startTimer(emqx.exproto.v1.Exproto.TimerRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_START_TIMER, getCallOptions()), request, responseObserver);
    }


    public void publish(emqx.exproto.v1.Exproto.PublishRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PUBLISH, getCallOptions()), request, responseObserver);
    }


    public void subscribe(emqx.exproto.v1.Exproto.SubscribeRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SUBSCRIBE, getCallOptions()), request, responseObserver);
    }


    public void unsubscribe(emqx.exproto.v1.Exproto.UnsubscribeRequest request,
        io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UNSUBSCRIBE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Broker side serivce. It provides a set of APIs to
   * handle a protcol access
   * </pre>
   */
  public static final class ConnectionAdapterBlockingStub extends io.grpc.stub.AbstractStub<ConnectionAdapterBlockingStub> {
    private ConnectionAdapterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectionAdapterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionAdapterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectionAdapterBlockingStub(channel, callOptions);
    }


    public emqx.exproto.v1.Exproto.CodeResponse send(emqx.exproto.v1.Exproto.SendBytesRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND, getCallOptions(), request);
    }


    public emqx.exproto.v1.Exproto.CodeResponse close(emqx.exproto.v1.Exproto.CloseSocketRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CLOSE, getCallOptions(), request);
    }


    public emqx.exproto.v1.Exproto.CodeResponse authenticate(emqx.exproto.v1.Exproto.AuthenticateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_AUTHENTICATE, getCallOptions(), request);
    }


    public emqx.exproto.v1.Exproto.CodeResponse startTimer(emqx.exproto.v1.Exproto.TimerRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_START_TIMER, getCallOptions(), request);
    }


    public emqx.exproto.v1.Exproto.CodeResponse publish(emqx.exproto.v1.Exproto.PublishRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PUBLISH, getCallOptions(), request);
    }


    public emqx.exproto.v1.Exproto.CodeResponse subscribe(emqx.exproto.v1.Exproto.SubscribeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SUBSCRIBE, getCallOptions(), request);
    }


    public emqx.exproto.v1.Exproto.CodeResponse unsubscribe(emqx.exproto.v1.Exproto.UnsubscribeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UNSUBSCRIBE, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Broker side serivce. It provides a set of APIs to
   * handle a protcol access
   * </pre>
   */
  public static final class ConnectionAdapterFutureStub extends io.grpc.stub.AbstractStub<ConnectionAdapterFutureStub> {
    private ConnectionAdapterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConnectionAdapterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectionAdapterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConnectionAdapterFutureStub(channel, callOptions);
    }


    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.CodeResponse> send(
        emqx.exproto.v1.Exproto.SendBytesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND, getCallOptions()), request);
    }


    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.CodeResponse> close(
        emqx.exproto.v1.Exproto.CloseSocketRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CLOSE, getCallOptions()), request);
    }


    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.CodeResponse> authenticate(
        emqx.exproto.v1.Exproto.AuthenticateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_AUTHENTICATE, getCallOptions()), request);
    }


    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.CodeResponse> startTimer(
        emqx.exproto.v1.Exproto.TimerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_START_TIMER, getCallOptions()), request);
    }


    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.CodeResponse> publish(
        emqx.exproto.v1.Exproto.PublishRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PUBLISH, getCallOptions()), request);
    }


    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.CodeResponse> subscribe(
        emqx.exproto.v1.Exproto.SubscribeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SUBSCRIBE, getCallOptions()), request);
    }


    public com.google.common.util.concurrent.ListenableFuture<emqx.exproto.v1.Exproto.CodeResponse> unsubscribe(
        emqx.exproto.v1.Exproto.UnsubscribeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UNSUBSCRIBE, getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND = 0;
  private static final int METHODID_CLOSE = 1;
  private static final int METHODID_AUTHENTICATE = 2;
  private static final int METHODID_START_TIMER = 3;
  private static final int METHODID_PUBLISH = 4;
  private static final int METHODID_SUBSCRIBE = 5;
  private static final int METHODID_UNSUBSCRIBE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConnectionAdapterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConnectionAdapterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND:
          serviceImpl.send((emqx.exproto.v1.Exproto.SendBytesRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse>) responseObserver);
          break;
        case METHODID_CLOSE:
          serviceImpl.close((emqx.exproto.v1.Exproto.CloseSocketRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse>) responseObserver);
          break;
        case METHODID_AUTHENTICATE:
          serviceImpl.authenticate((emqx.exproto.v1.Exproto.AuthenticateRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse>) responseObserver);
          break;
        case METHODID_START_TIMER:
          serviceImpl.startTimer((emqx.exproto.v1.Exproto.TimerRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse>) responseObserver);
          break;
        case METHODID_PUBLISH:
          serviceImpl.publish((emqx.exproto.v1.Exproto.PublishRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((emqx.exproto.v1.Exproto.SubscribeRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse>) responseObserver);
          break;
        case METHODID_UNSUBSCRIBE:
          serviceImpl.unsubscribe((emqx.exproto.v1.Exproto.UnsubscribeRequest) request,
              (io.grpc.stub.StreamObserver<emqx.exproto.v1.Exproto.CodeResponse>) responseObserver);
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

  private static final class ConnectionAdapterDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return emqx.exproto.v1.Exproto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConnectionAdapterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConnectionAdapterDescriptorSupplier())
              .addMethod(METHOD_SEND)
              .addMethod(METHOD_CLOSE)
              .addMethod(METHOD_AUTHENTICATE)
              .addMethod(METHOD_START_TIMER)
              .addMethod(METHOD_PUBLISH)
              .addMethod(METHOD_SUBSCRIBE)
              .addMethod(METHOD_UNSUBSCRIBE)
              .build();
        }
      }
    }
    return result;
  }
}
