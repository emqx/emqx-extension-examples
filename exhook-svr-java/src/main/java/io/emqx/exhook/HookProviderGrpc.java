package io.emqx.exhook;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: exhook.proto")
public final class HookProviderGrpc {

  private HookProviderGrpc() {}

  public static final String SERVICE_NAME = "emqx.exhook.v1.HookProvider";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.ProviderLoadedRequest,
      io.emqx.exhook.LoadedResponse> getOnProviderLoadedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnProviderLoaded",
      requestType = io.emqx.exhook.ProviderLoadedRequest.class,
      responseType = io.emqx.exhook.LoadedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.ProviderLoadedRequest,
      io.emqx.exhook.LoadedResponse> getOnProviderLoadedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.ProviderLoadedRequest, io.emqx.exhook.LoadedResponse> getOnProviderLoadedMethod;
    if ((getOnProviderLoadedMethod = HookProviderGrpc.getOnProviderLoadedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnProviderLoadedMethod = HookProviderGrpc.getOnProviderLoadedMethod) == null) {
          HookProviderGrpc.getOnProviderLoadedMethod = getOnProviderLoadedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.ProviderLoadedRequest, io.emqx.exhook.LoadedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnProviderLoaded"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ProviderLoadedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.LoadedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnProviderLoaded"))
              .build();
        }
      }
    }
    return getOnProviderLoadedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.ProviderUnloadedRequest,
      io.emqx.exhook.EmptySuccess> getOnProviderUnloadedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnProviderUnloaded",
      requestType = io.emqx.exhook.ProviderUnloadedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.ProviderUnloadedRequest,
      io.emqx.exhook.EmptySuccess> getOnProviderUnloadedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.ProviderUnloadedRequest, io.emqx.exhook.EmptySuccess> getOnProviderUnloadedMethod;
    if ((getOnProviderUnloadedMethod = HookProviderGrpc.getOnProviderUnloadedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnProviderUnloadedMethod = HookProviderGrpc.getOnProviderUnloadedMethod) == null) {
          HookProviderGrpc.getOnProviderUnloadedMethod = getOnProviderUnloadedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.ProviderUnloadedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnProviderUnloaded"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ProviderUnloadedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnProviderUnloaded"))
              .build();
        }
      }
    }
    return getOnProviderUnloadedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.ClientConnectRequest,
      io.emqx.exhook.EmptySuccess> getOnClientConnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientConnect",
      requestType = io.emqx.exhook.ClientConnectRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.ClientConnectRequest,
      io.emqx.exhook.EmptySuccess> getOnClientConnectMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.ClientConnectRequest, io.emqx.exhook.EmptySuccess> getOnClientConnectMethod;
    if ((getOnClientConnectMethod = HookProviderGrpc.getOnClientConnectMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientConnectMethod = HookProviderGrpc.getOnClientConnectMethod) == null) {
          HookProviderGrpc.getOnClientConnectMethod = getOnClientConnectMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.ClientConnectRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientConnect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ClientConnectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientConnect"))
              .build();
        }
      }
    }
    return getOnClientConnectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.ClientConnackRequest,
      io.emqx.exhook.EmptySuccess> getOnClientConnackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientConnack",
      requestType = io.emqx.exhook.ClientConnackRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.ClientConnackRequest,
      io.emqx.exhook.EmptySuccess> getOnClientConnackMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.ClientConnackRequest, io.emqx.exhook.EmptySuccess> getOnClientConnackMethod;
    if ((getOnClientConnackMethod = HookProviderGrpc.getOnClientConnackMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientConnackMethod = HookProviderGrpc.getOnClientConnackMethod) == null) {
          HookProviderGrpc.getOnClientConnackMethod = getOnClientConnackMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.ClientConnackRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientConnack"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ClientConnackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientConnack"))
              .build();
        }
      }
    }
    return getOnClientConnackMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.ClientConnectedRequest,
      io.emqx.exhook.EmptySuccess> getOnClientConnectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientConnected",
      requestType = io.emqx.exhook.ClientConnectedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.ClientConnectedRequest,
      io.emqx.exhook.EmptySuccess> getOnClientConnectedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.ClientConnectedRequest, io.emqx.exhook.EmptySuccess> getOnClientConnectedMethod;
    if ((getOnClientConnectedMethod = HookProviderGrpc.getOnClientConnectedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientConnectedMethod = HookProviderGrpc.getOnClientConnectedMethod) == null) {
          HookProviderGrpc.getOnClientConnectedMethod = getOnClientConnectedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.ClientConnectedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientConnected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ClientConnectedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientConnected"))
              .build();
        }
      }
    }
    return getOnClientConnectedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.ClientDisconnectedRequest,
      io.emqx.exhook.EmptySuccess> getOnClientDisconnectedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientDisconnected",
      requestType = io.emqx.exhook.ClientDisconnectedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.ClientDisconnectedRequest,
      io.emqx.exhook.EmptySuccess> getOnClientDisconnectedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.ClientDisconnectedRequest, io.emqx.exhook.EmptySuccess> getOnClientDisconnectedMethod;
    if ((getOnClientDisconnectedMethod = HookProviderGrpc.getOnClientDisconnectedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientDisconnectedMethod = HookProviderGrpc.getOnClientDisconnectedMethod) == null) {
          HookProviderGrpc.getOnClientDisconnectedMethod = getOnClientDisconnectedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.ClientDisconnectedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientDisconnected"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ClientDisconnectedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientDisconnected"))
              .build();
        }
      }
    }
    return getOnClientDisconnectedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.ClientAuthenticateRequest,
      io.emqx.exhook.ValuedResponse> getOnClientAuthenticateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientAuthenticate",
      requestType = io.emqx.exhook.ClientAuthenticateRequest.class,
      responseType = io.emqx.exhook.ValuedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.ClientAuthenticateRequest,
      io.emqx.exhook.ValuedResponse> getOnClientAuthenticateMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.ClientAuthenticateRequest, io.emqx.exhook.ValuedResponse> getOnClientAuthenticateMethod;
    if ((getOnClientAuthenticateMethod = HookProviderGrpc.getOnClientAuthenticateMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientAuthenticateMethod = HookProviderGrpc.getOnClientAuthenticateMethod) == null) {
          HookProviderGrpc.getOnClientAuthenticateMethod = getOnClientAuthenticateMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.ClientAuthenticateRequest, io.emqx.exhook.ValuedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientAuthenticate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ClientAuthenticateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ValuedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientAuthenticate"))
              .build();
        }
      }
    }
    return getOnClientAuthenticateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.ClientCheckAclRequest,
      io.emqx.exhook.ValuedResponse> getOnClientCheckAclMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientCheckAcl",
      requestType = io.emqx.exhook.ClientCheckAclRequest.class,
      responseType = io.emqx.exhook.ValuedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.ClientCheckAclRequest,
      io.emqx.exhook.ValuedResponse> getOnClientCheckAclMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.ClientCheckAclRequest, io.emqx.exhook.ValuedResponse> getOnClientCheckAclMethod;
    if ((getOnClientCheckAclMethod = HookProviderGrpc.getOnClientCheckAclMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientCheckAclMethod = HookProviderGrpc.getOnClientCheckAclMethod) == null) {
          HookProviderGrpc.getOnClientCheckAclMethod = getOnClientCheckAclMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.ClientCheckAclRequest, io.emqx.exhook.ValuedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientCheckAcl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ClientCheckAclRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ValuedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientCheckAcl"))
              .build();
        }
      }
    }
    return getOnClientCheckAclMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.ClientSubscribeRequest,
      io.emqx.exhook.EmptySuccess> getOnClientSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientSubscribe",
      requestType = io.emqx.exhook.ClientSubscribeRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.ClientSubscribeRequest,
      io.emqx.exhook.EmptySuccess> getOnClientSubscribeMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.ClientSubscribeRequest, io.emqx.exhook.EmptySuccess> getOnClientSubscribeMethod;
    if ((getOnClientSubscribeMethod = HookProviderGrpc.getOnClientSubscribeMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientSubscribeMethod = HookProviderGrpc.getOnClientSubscribeMethod) == null) {
          HookProviderGrpc.getOnClientSubscribeMethod = getOnClientSubscribeMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.ClientSubscribeRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientSubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ClientSubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientSubscribe"))
              .build();
        }
      }
    }
    return getOnClientSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.ClientUnsubscribeRequest,
      io.emqx.exhook.EmptySuccess> getOnClientUnsubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnClientUnsubscribe",
      requestType = io.emqx.exhook.ClientUnsubscribeRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.ClientUnsubscribeRequest,
      io.emqx.exhook.EmptySuccess> getOnClientUnsubscribeMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.ClientUnsubscribeRequest, io.emqx.exhook.EmptySuccess> getOnClientUnsubscribeMethod;
    if ((getOnClientUnsubscribeMethod = HookProviderGrpc.getOnClientUnsubscribeMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnClientUnsubscribeMethod = HookProviderGrpc.getOnClientUnsubscribeMethod) == null) {
          HookProviderGrpc.getOnClientUnsubscribeMethod = getOnClientUnsubscribeMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.ClientUnsubscribeRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnClientUnsubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ClientUnsubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnClientUnsubscribe"))
              .build();
        }
      }
    }
    return getOnClientUnsubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.SessionCreatedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionCreatedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionCreated",
      requestType = io.emqx.exhook.SessionCreatedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.SessionCreatedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionCreatedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.SessionCreatedRequest, io.emqx.exhook.EmptySuccess> getOnSessionCreatedMethod;
    if ((getOnSessionCreatedMethod = HookProviderGrpc.getOnSessionCreatedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionCreatedMethod = HookProviderGrpc.getOnSessionCreatedMethod) == null) {
          HookProviderGrpc.getOnSessionCreatedMethod = getOnSessionCreatedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.SessionCreatedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionCreated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.SessionCreatedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionCreated"))
              .build();
        }
      }
    }
    return getOnSessionCreatedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.SessionSubscribedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionSubscribedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionSubscribed",
      requestType = io.emqx.exhook.SessionSubscribedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.SessionSubscribedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionSubscribedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.SessionSubscribedRequest, io.emqx.exhook.EmptySuccess> getOnSessionSubscribedMethod;
    if ((getOnSessionSubscribedMethod = HookProviderGrpc.getOnSessionSubscribedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionSubscribedMethod = HookProviderGrpc.getOnSessionSubscribedMethod) == null) {
          HookProviderGrpc.getOnSessionSubscribedMethod = getOnSessionSubscribedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.SessionSubscribedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionSubscribed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.SessionSubscribedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionSubscribed"))
              .build();
        }
      }
    }
    return getOnSessionSubscribedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.SessionUnsubscribedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionUnsubscribedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionUnsubscribed",
      requestType = io.emqx.exhook.SessionUnsubscribedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.SessionUnsubscribedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionUnsubscribedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.SessionUnsubscribedRequest, io.emqx.exhook.EmptySuccess> getOnSessionUnsubscribedMethod;
    if ((getOnSessionUnsubscribedMethod = HookProviderGrpc.getOnSessionUnsubscribedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionUnsubscribedMethod = HookProviderGrpc.getOnSessionUnsubscribedMethod) == null) {
          HookProviderGrpc.getOnSessionUnsubscribedMethod = getOnSessionUnsubscribedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.SessionUnsubscribedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionUnsubscribed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.SessionUnsubscribedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionUnsubscribed"))
              .build();
        }
      }
    }
    return getOnSessionUnsubscribedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.SessionResumedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionResumedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionResumed",
      requestType = io.emqx.exhook.SessionResumedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.SessionResumedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionResumedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.SessionResumedRequest, io.emqx.exhook.EmptySuccess> getOnSessionResumedMethod;
    if ((getOnSessionResumedMethod = HookProviderGrpc.getOnSessionResumedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionResumedMethod = HookProviderGrpc.getOnSessionResumedMethod) == null) {
          HookProviderGrpc.getOnSessionResumedMethod = getOnSessionResumedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.SessionResumedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionResumed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.SessionResumedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionResumed"))
              .build();
        }
      }
    }
    return getOnSessionResumedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.SessionDiscardedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionDiscardedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionDiscarded",
      requestType = io.emqx.exhook.SessionDiscardedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.SessionDiscardedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionDiscardedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.SessionDiscardedRequest, io.emqx.exhook.EmptySuccess> getOnSessionDiscardedMethod;
    if ((getOnSessionDiscardedMethod = HookProviderGrpc.getOnSessionDiscardedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionDiscardedMethod = HookProviderGrpc.getOnSessionDiscardedMethod) == null) {
          HookProviderGrpc.getOnSessionDiscardedMethod = getOnSessionDiscardedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.SessionDiscardedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionDiscarded"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.SessionDiscardedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionDiscarded"))
              .build();
        }
      }
    }
    return getOnSessionDiscardedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.SessionTakeoveredRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionTakeoveredMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionTakeovered",
      requestType = io.emqx.exhook.SessionTakeoveredRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.SessionTakeoveredRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionTakeoveredMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.SessionTakeoveredRequest, io.emqx.exhook.EmptySuccess> getOnSessionTakeoveredMethod;
    if ((getOnSessionTakeoveredMethod = HookProviderGrpc.getOnSessionTakeoveredMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionTakeoveredMethod = HookProviderGrpc.getOnSessionTakeoveredMethod) == null) {
          HookProviderGrpc.getOnSessionTakeoveredMethod = getOnSessionTakeoveredMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.SessionTakeoveredRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionTakeovered"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.SessionTakeoveredRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionTakeovered"))
              .build();
        }
      }
    }
    return getOnSessionTakeoveredMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.SessionTerminatedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionTerminatedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnSessionTerminated",
      requestType = io.emqx.exhook.SessionTerminatedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.SessionTerminatedRequest,
      io.emqx.exhook.EmptySuccess> getOnSessionTerminatedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.SessionTerminatedRequest, io.emqx.exhook.EmptySuccess> getOnSessionTerminatedMethod;
    if ((getOnSessionTerminatedMethod = HookProviderGrpc.getOnSessionTerminatedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnSessionTerminatedMethod = HookProviderGrpc.getOnSessionTerminatedMethod) == null) {
          HookProviderGrpc.getOnSessionTerminatedMethod = getOnSessionTerminatedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.SessionTerminatedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnSessionTerminated"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.SessionTerminatedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnSessionTerminated"))
              .build();
        }
      }
    }
    return getOnSessionTerminatedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.MessagePublishRequest,
      io.emqx.exhook.ValuedResponse> getOnMessagePublishMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnMessagePublish",
      requestType = io.emqx.exhook.MessagePublishRequest.class,
      responseType = io.emqx.exhook.ValuedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.MessagePublishRequest,
      io.emqx.exhook.ValuedResponse> getOnMessagePublishMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.MessagePublishRequest, io.emqx.exhook.ValuedResponse> getOnMessagePublishMethod;
    if ((getOnMessagePublishMethod = HookProviderGrpc.getOnMessagePublishMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnMessagePublishMethod = HookProviderGrpc.getOnMessagePublishMethod) == null) {
          HookProviderGrpc.getOnMessagePublishMethod = getOnMessagePublishMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.MessagePublishRequest, io.emqx.exhook.ValuedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnMessagePublish"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.MessagePublishRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.ValuedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnMessagePublish"))
              .build();
        }
      }
    }
    return getOnMessagePublishMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.MessageDeliveredRequest,
      io.emqx.exhook.EmptySuccess> getOnMessageDeliveredMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnMessageDelivered",
      requestType = io.emqx.exhook.MessageDeliveredRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.MessageDeliveredRequest,
      io.emqx.exhook.EmptySuccess> getOnMessageDeliveredMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.MessageDeliveredRequest, io.emqx.exhook.EmptySuccess> getOnMessageDeliveredMethod;
    if ((getOnMessageDeliveredMethod = HookProviderGrpc.getOnMessageDeliveredMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnMessageDeliveredMethod = HookProviderGrpc.getOnMessageDeliveredMethod) == null) {
          HookProviderGrpc.getOnMessageDeliveredMethod = getOnMessageDeliveredMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.MessageDeliveredRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnMessageDelivered"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.MessageDeliveredRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnMessageDelivered"))
              .build();
        }
      }
    }
    return getOnMessageDeliveredMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.MessageDroppedRequest,
      io.emqx.exhook.EmptySuccess> getOnMessageDroppedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnMessageDropped",
      requestType = io.emqx.exhook.MessageDroppedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.MessageDroppedRequest,
      io.emqx.exhook.EmptySuccess> getOnMessageDroppedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.MessageDroppedRequest, io.emqx.exhook.EmptySuccess> getOnMessageDroppedMethod;
    if ((getOnMessageDroppedMethod = HookProviderGrpc.getOnMessageDroppedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnMessageDroppedMethod = HookProviderGrpc.getOnMessageDroppedMethod) == null) {
          HookProviderGrpc.getOnMessageDroppedMethod = getOnMessageDroppedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.MessageDroppedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnMessageDropped"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.MessageDroppedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnMessageDropped"))
              .build();
        }
      }
    }
    return getOnMessageDroppedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.emqx.exhook.MessageAckedRequest,
      io.emqx.exhook.EmptySuccess> getOnMessageAckedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OnMessageAcked",
      requestType = io.emqx.exhook.MessageAckedRequest.class,
      responseType = io.emqx.exhook.EmptySuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.emqx.exhook.MessageAckedRequest,
      io.emqx.exhook.EmptySuccess> getOnMessageAckedMethod() {
    io.grpc.MethodDescriptor<io.emqx.exhook.MessageAckedRequest, io.emqx.exhook.EmptySuccess> getOnMessageAckedMethod;
    if ((getOnMessageAckedMethod = HookProviderGrpc.getOnMessageAckedMethod) == null) {
      synchronized (HookProviderGrpc.class) {
        if ((getOnMessageAckedMethod = HookProviderGrpc.getOnMessageAckedMethod) == null) {
          HookProviderGrpc.getOnMessageAckedMethod = getOnMessageAckedMethod =
              io.grpc.MethodDescriptor.<io.emqx.exhook.MessageAckedRequest, io.emqx.exhook.EmptySuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OnMessageAcked"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.MessageAckedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.emqx.exhook.EmptySuccess.getDefaultInstance()))
              .setSchemaDescriptor(new HookProviderMethodDescriptorSupplier("OnMessageAcked"))
              .build();
        }
      }
    }
    return getOnMessageAckedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HookProviderStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HookProviderStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HookProviderStub>() {
        @java.lang.Override
        public HookProviderStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HookProviderStub(channel, callOptions);
        }
      };
    return HookProviderStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HookProviderBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HookProviderBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HookProviderBlockingStub>() {
        @java.lang.Override
        public HookProviderBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HookProviderBlockingStub(channel, callOptions);
        }
      };
    return HookProviderBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HookProviderFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HookProviderFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HookProviderFutureStub>() {
        @java.lang.Override
        public HookProviderFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HookProviderFutureStub(channel, callOptions);
        }
      };
    return HookProviderFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HookProviderImplBase implements io.grpc.BindableService {

    /**
     */
    public void onProviderLoaded(io.emqx.exhook.ProviderLoadedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.LoadedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnProviderLoadedMethod(), responseObserver);
    }

    /**
     */
    public void onProviderUnloaded(io.emqx.exhook.ProviderUnloadedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnProviderUnloadedMethod(), responseObserver);
    }

    /**
     */
    public void onClientConnect(io.emqx.exhook.ClientConnectRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientConnectMethod(), responseObserver);
    }

    /**
     */
    public void onClientConnack(io.emqx.exhook.ClientConnackRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientConnackMethod(), responseObserver);
    }

    /**
     */
    public void onClientConnected(io.emqx.exhook.ClientConnectedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientConnectedMethod(), responseObserver);
    }

    /**
     */
    public void onClientDisconnected(io.emqx.exhook.ClientDisconnectedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientDisconnectedMethod(), responseObserver);
    }

    /**
     */
    public void onClientAuthenticate(io.emqx.exhook.ClientAuthenticateRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.ValuedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientAuthenticateMethod(), responseObserver);
    }

    /**
     */
    public void onClientCheckAcl(io.emqx.exhook.ClientCheckAclRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.ValuedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientCheckAclMethod(), responseObserver);
    }

    /**
     */
    public void onClientSubscribe(io.emqx.exhook.ClientSubscribeRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientSubscribeMethod(), responseObserver);
    }

    /**
     */
    public void onClientUnsubscribe(io.emqx.exhook.ClientUnsubscribeRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnClientUnsubscribeMethod(), responseObserver);
    }

    /**
     */
    public void onSessionCreated(io.emqx.exhook.SessionCreatedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionCreatedMethod(), responseObserver);
    }

    /**
     */
    public void onSessionSubscribed(io.emqx.exhook.SessionSubscribedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionSubscribedMethod(), responseObserver);
    }

    /**
     */
    public void onSessionUnsubscribed(io.emqx.exhook.SessionUnsubscribedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionUnsubscribedMethod(), responseObserver);
    }

    /**
     */
    public void onSessionResumed(io.emqx.exhook.SessionResumedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionResumedMethod(), responseObserver);
    }

    /**
     */
    public void onSessionDiscarded(io.emqx.exhook.SessionDiscardedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionDiscardedMethod(), responseObserver);
    }

    /**
     */
    public void onSessionTakeovered(io.emqx.exhook.SessionTakeoveredRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionTakeoveredMethod(), responseObserver);
    }

    /**
     */
    public void onSessionTerminated(io.emqx.exhook.SessionTerminatedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnSessionTerminatedMethod(), responseObserver);
    }

    /**
     */
    public void onMessagePublish(io.emqx.exhook.MessagePublishRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.ValuedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMessagePublishMethod(), responseObserver);
    }

    /**
     */
    public void onMessageDelivered(io.emqx.exhook.MessageDeliveredRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMessageDeliveredMethod(), responseObserver);
    }

    /**
     */
    public void onMessageDropped(io.emqx.exhook.MessageDroppedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMessageDroppedMethod(), responseObserver);
    }

    /**
     */
    public void onMessageAcked(io.emqx.exhook.MessageAckedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnMessageAckedMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOnProviderLoadedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.ProviderLoadedRequest,
                io.emqx.exhook.LoadedResponse>(
                  this, METHODID_ON_PROVIDER_LOADED)))
          .addMethod(
            getOnProviderUnloadedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.ProviderUnloadedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_PROVIDER_UNLOADED)))
          .addMethod(
            getOnClientConnectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.ClientConnectRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_CLIENT_CONNECT)))
          .addMethod(
            getOnClientConnackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.ClientConnackRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_CLIENT_CONNACK)))
          .addMethod(
            getOnClientConnectedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.ClientConnectedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_CLIENT_CONNECTED)))
          .addMethod(
            getOnClientDisconnectedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.ClientDisconnectedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_CLIENT_DISCONNECTED)))
          .addMethod(
            getOnClientAuthenticateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.ClientAuthenticateRequest,
                io.emqx.exhook.ValuedResponse>(
                  this, METHODID_ON_CLIENT_AUTHENTICATE)))
          .addMethod(
            getOnClientCheckAclMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.ClientCheckAclRequest,
                io.emqx.exhook.ValuedResponse>(
                  this, METHODID_ON_CLIENT_CHECK_ACL)))
          .addMethod(
            getOnClientSubscribeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.ClientSubscribeRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_CLIENT_SUBSCRIBE)))
          .addMethod(
            getOnClientUnsubscribeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.ClientUnsubscribeRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_CLIENT_UNSUBSCRIBE)))
          .addMethod(
            getOnSessionCreatedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.SessionCreatedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_SESSION_CREATED)))
          .addMethod(
            getOnSessionSubscribedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.SessionSubscribedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_SESSION_SUBSCRIBED)))
          .addMethod(
            getOnSessionUnsubscribedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.SessionUnsubscribedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_SESSION_UNSUBSCRIBED)))
          .addMethod(
            getOnSessionResumedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.SessionResumedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_SESSION_RESUMED)))
          .addMethod(
            getOnSessionDiscardedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.SessionDiscardedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_SESSION_DISCARDED)))
          .addMethod(
            getOnSessionTakeoveredMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.SessionTakeoveredRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_SESSION_TAKEOVERED)))
          .addMethod(
            getOnSessionTerminatedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.SessionTerminatedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_SESSION_TERMINATED)))
          .addMethod(
            getOnMessagePublishMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.MessagePublishRequest,
                io.emqx.exhook.ValuedResponse>(
                  this, METHODID_ON_MESSAGE_PUBLISH)))
          .addMethod(
            getOnMessageDeliveredMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.MessageDeliveredRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_MESSAGE_DELIVERED)))
          .addMethod(
            getOnMessageDroppedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.MessageDroppedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_MESSAGE_DROPPED)))
          .addMethod(
            getOnMessageAckedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                io.emqx.exhook.MessageAckedRequest,
                io.emqx.exhook.EmptySuccess>(
                  this, METHODID_ON_MESSAGE_ACKED)))
          .build();
    }
  }

  /**
   */
  public static final class HookProviderStub extends io.grpc.stub.AbstractAsyncStub<HookProviderStub> {
    private HookProviderStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HookProviderStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HookProviderStub(channel, callOptions);
    }

    /**
     */
    public void onProviderLoaded(io.emqx.exhook.ProviderLoadedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.LoadedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnProviderLoadedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onProviderUnloaded(io.emqx.exhook.ProviderUnloadedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnProviderUnloadedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientConnect(io.emqx.exhook.ClientConnectRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientConnectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientConnack(io.emqx.exhook.ClientConnackRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientConnackMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientConnected(io.emqx.exhook.ClientConnectedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientConnectedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientDisconnected(io.emqx.exhook.ClientDisconnectedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientDisconnectedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientAuthenticate(io.emqx.exhook.ClientAuthenticateRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.ValuedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientAuthenticateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientCheckAcl(io.emqx.exhook.ClientCheckAclRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.ValuedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientCheckAclMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientSubscribe(io.emqx.exhook.ClientSubscribeRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onClientUnsubscribe(io.emqx.exhook.ClientUnsubscribeRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnClientUnsubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionCreated(io.emqx.exhook.SessionCreatedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionCreatedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionSubscribed(io.emqx.exhook.SessionSubscribedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionSubscribedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionUnsubscribed(io.emqx.exhook.SessionUnsubscribedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionUnsubscribedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionResumed(io.emqx.exhook.SessionResumedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionResumedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionDiscarded(io.emqx.exhook.SessionDiscardedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionDiscardedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionTakeovered(io.emqx.exhook.SessionTakeoveredRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionTakeoveredMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onSessionTerminated(io.emqx.exhook.SessionTerminatedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnSessionTerminatedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMessagePublish(io.emqx.exhook.MessagePublishRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.ValuedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMessagePublishMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMessageDelivered(io.emqx.exhook.MessageDeliveredRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMessageDeliveredMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMessageDropped(io.emqx.exhook.MessageDroppedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMessageDroppedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onMessageAcked(io.emqx.exhook.MessageAckedRequest request,
        io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnMessageAckedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HookProviderBlockingStub extends io.grpc.stub.AbstractBlockingStub<HookProviderBlockingStub> {
    private HookProviderBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HookProviderBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HookProviderBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.emqx.exhook.LoadedResponse onProviderLoaded(io.emqx.exhook.ProviderLoadedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnProviderLoadedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onProviderUnloaded(io.emqx.exhook.ProviderUnloadedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnProviderUnloadedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onClientConnect(io.emqx.exhook.ClientConnectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientConnectMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onClientConnack(io.emqx.exhook.ClientConnackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientConnackMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onClientConnected(io.emqx.exhook.ClientConnectedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientConnectedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onClientDisconnected(io.emqx.exhook.ClientDisconnectedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientDisconnectedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.ValuedResponse onClientAuthenticate(io.emqx.exhook.ClientAuthenticateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientAuthenticateMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.ValuedResponse onClientCheckAcl(io.emqx.exhook.ClientCheckAclRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientCheckAclMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onClientSubscribe(io.emqx.exhook.ClientSubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onClientUnsubscribe(io.emqx.exhook.ClientUnsubscribeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnClientUnsubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onSessionCreated(io.emqx.exhook.SessionCreatedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionCreatedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onSessionSubscribed(io.emqx.exhook.SessionSubscribedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionSubscribedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onSessionUnsubscribed(io.emqx.exhook.SessionUnsubscribedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionUnsubscribedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onSessionResumed(io.emqx.exhook.SessionResumedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionResumedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onSessionDiscarded(io.emqx.exhook.SessionDiscardedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionDiscardedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onSessionTakeovered(io.emqx.exhook.SessionTakeoveredRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionTakeoveredMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onSessionTerminated(io.emqx.exhook.SessionTerminatedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnSessionTerminatedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.ValuedResponse onMessagePublish(io.emqx.exhook.MessagePublishRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMessagePublishMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onMessageDelivered(io.emqx.exhook.MessageDeliveredRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMessageDeliveredMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onMessageDropped(io.emqx.exhook.MessageDroppedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMessageDroppedMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.emqx.exhook.EmptySuccess onMessageAcked(io.emqx.exhook.MessageAckedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnMessageAckedMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HookProviderFutureStub extends io.grpc.stub.AbstractFutureStub<HookProviderFutureStub> {
    private HookProviderFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HookProviderFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HookProviderFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.LoadedResponse> onProviderLoaded(
        io.emqx.exhook.ProviderLoadedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnProviderLoadedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onProviderUnloaded(
        io.emqx.exhook.ProviderUnloadedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnProviderUnloadedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onClientConnect(
        io.emqx.exhook.ClientConnectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientConnectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onClientConnack(
        io.emqx.exhook.ClientConnackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientConnackMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onClientConnected(
        io.emqx.exhook.ClientConnectedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientConnectedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onClientDisconnected(
        io.emqx.exhook.ClientDisconnectedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientDisconnectedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.ValuedResponse> onClientAuthenticate(
        io.emqx.exhook.ClientAuthenticateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientAuthenticateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.ValuedResponse> onClientCheckAcl(
        io.emqx.exhook.ClientCheckAclRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientCheckAclMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onClientSubscribe(
        io.emqx.exhook.ClientSubscribeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientSubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onClientUnsubscribe(
        io.emqx.exhook.ClientUnsubscribeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnClientUnsubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onSessionCreated(
        io.emqx.exhook.SessionCreatedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionCreatedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onSessionSubscribed(
        io.emqx.exhook.SessionSubscribedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionSubscribedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onSessionUnsubscribed(
        io.emqx.exhook.SessionUnsubscribedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionUnsubscribedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onSessionResumed(
        io.emqx.exhook.SessionResumedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionResumedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onSessionDiscarded(
        io.emqx.exhook.SessionDiscardedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionDiscardedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onSessionTakeovered(
        io.emqx.exhook.SessionTakeoveredRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionTakeoveredMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onSessionTerminated(
        io.emqx.exhook.SessionTerminatedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnSessionTerminatedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.ValuedResponse> onMessagePublish(
        io.emqx.exhook.MessagePublishRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMessagePublishMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onMessageDelivered(
        io.emqx.exhook.MessageDeliveredRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMessageDeliveredMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onMessageDropped(
        io.emqx.exhook.MessageDroppedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMessageDroppedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.emqx.exhook.EmptySuccess> onMessageAcked(
        io.emqx.exhook.MessageAckedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnMessageAckedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ON_PROVIDER_LOADED = 0;
  private static final int METHODID_ON_PROVIDER_UNLOADED = 1;
  private static final int METHODID_ON_CLIENT_CONNECT = 2;
  private static final int METHODID_ON_CLIENT_CONNACK = 3;
  private static final int METHODID_ON_CLIENT_CONNECTED = 4;
  private static final int METHODID_ON_CLIENT_DISCONNECTED = 5;
  private static final int METHODID_ON_CLIENT_AUTHENTICATE = 6;
  private static final int METHODID_ON_CLIENT_CHECK_ACL = 7;
  private static final int METHODID_ON_CLIENT_SUBSCRIBE = 8;
  private static final int METHODID_ON_CLIENT_UNSUBSCRIBE = 9;
  private static final int METHODID_ON_SESSION_CREATED = 10;
  private static final int METHODID_ON_SESSION_SUBSCRIBED = 11;
  private static final int METHODID_ON_SESSION_UNSUBSCRIBED = 12;
  private static final int METHODID_ON_SESSION_RESUMED = 13;
  private static final int METHODID_ON_SESSION_DISCARDED = 14;
  private static final int METHODID_ON_SESSION_TAKEOVERED = 15;
  private static final int METHODID_ON_SESSION_TERMINATED = 16;
  private static final int METHODID_ON_MESSAGE_PUBLISH = 17;
  private static final int METHODID_ON_MESSAGE_DELIVERED = 18;
  private static final int METHODID_ON_MESSAGE_DROPPED = 19;
  private static final int METHODID_ON_MESSAGE_ACKED = 20;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HookProviderImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HookProviderImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ON_PROVIDER_LOADED:
          serviceImpl.onProviderLoaded((io.emqx.exhook.ProviderLoadedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.LoadedResponse>) responseObserver);
          break;
        case METHODID_ON_PROVIDER_UNLOADED:
          serviceImpl.onProviderUnloaded((io.emqx.exhook.ProviderUnloadedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_CONNECT:
          serviceImpl.onClientConnect((io.emqx.exhook.ClientConnectRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_CONNACK:
          serviceImpl.onClientConnack((io.emqx.exhook.ClientConnackRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_CONNECTED:
          serviceImpl.onClientConnected((io.emqx.exhook.ClientConnectedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_DISCONNECTED:
          serviceImpl.onClientDisconnected((io.emqx.exhook.ClientDisconnectedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_AUTHENTICATE:
          serviceImpl.onClientAuthenticate((io.emqx.exhook.ClientAuthenticateRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.ValuedResponse>) responseObserver);
          break;
        case METHODID_ON_CLIENT_CHECK_ACL:
          serviceImpl.onClientCheckAcl((io.emqx.exhook.ClientCheckAclRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.ValuedResponse>) responseObserver);
          break;
        case METHODID_ON_CLIENT_SUBSCRIBE:
          serviceImpl.onClientSubscribe((io.emqx.exhook.ClientSubscribeRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_CLIENT_UNSUBSCRIBE:
          serviceImpl.onClientUnsubscribe((io.emqx.exhook.ClientUnsubscribeRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_CREATED:
          serviceImpl.onSessionCreated((io.emqx.exhook.SessionCreatedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_SUBSCRIBED:
          serviceImpl.onSessionSubscribed((io.emqx.exhook.SessionSubscribedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_UNSUBSCRIBED:
          serviceImpl.onSessionUnsubscribed((io.emqx.exhook.SessionUnsubscribedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_RESUMED:
          serviceImpl.onSessionResumed((io.emqx.exhook.SessionResumedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_DISCARDED:
          serviceImpl.onSessionDiscarded((io.emqx.exhook.SessionDiscardedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_TAKEOVERED:
          serviceImpl.onSessionTakeovered((io.emqx.exhook.SessionTakeoveredRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_SESSION_TERMINATED:
          serviceImpl.onSessionTerminated((io.emqx.exhook.SessionTerminatedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_MESSAGE_PUBLISH:
          serviceImpl.onMessagePublish((io.emqx.exhook.MessagePublishRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.ValuedResponse>) responseObserver);
          break;
        case METHODID_ON_MESSAGE_DELIVERED:
          serviceImpl.onMessageDelivered((io.emqx.exhook.MessageDeliveredRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_MESSAGE_DROPPED:
          serviceImpl.onMessageDropped((io.emqx.exhook.MessageDroppedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
          break;
        case METHODID_ON_MESSAGE_ACKED:
          serviceImpl.onMessageAcked((io.emqx.exhook.MessageAckedRequest) request,
              (io.grpc.stub.StreamObserver<io.emqx.exhook.EmptySuccess>) responseObserver);
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

  private static abstract class HookProviderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HookProviderBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.emqx.exhook.EmqxExHookProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HookProvider");
    }
  }

  private static final class HookProviderFileDescriptorSupplier
      extends HookProviderBaseDescriptorSupplier {
    HookProviderFileDescriptorSupplier() {}
  }

  private static final class HookProviderMethodDescriptorSupplier
      extends HookProviderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HookProviderMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HookProviderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HookProviderFileDescriptorSupplier())
              .addMethod(getOnProviderLoadedMethod())
              .addMethod(getOnProviderUnloadedMethod())
              .addMethod(getOnClientConnectMethod())
              .addMethod(getOnClientConnackMethod())
              .addMethod(getOnClientConnectedMethod())
              .addMethod(getOnClientDisconnectedMethod())
              .addMethod(getOnClientAuthenticateMethod())
              .addMethod(getOnClientCheckAclMethod())
              .addMethod(getOnClientSubscribeMethod())
              .addMethod(getOnClientUnsubscribeMethod())
              .addMethod(getOnSessionCreatedMethod())
              .addMethod(getOnSessionSubscribedMethod())
              .addMethod(getOnSessionUnsubscribedMethod())
              .addMethod(getOnSessionResumedMethod())
              .addMethod(getOnSessionDiscardedMethod())
              .addMethod(getOnSessionTakeoveredMethod())
              .addMethod(getOnSessionTerminatedMethod())
              .addMethod(getOnMessagePublishMethod())
              .addMethod(getOnMessageDeliveredMethod())
              .addMethod(getOnMessageDroppedMethod())
              .addMethod(getOnMessageAckedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
