# exhook-svr-python

This is a demo server written in python for exhook

## Prerequisites

- [Python](https://www.python.org) 3.5 or higher
- pip version 9.0.1 or higher
- EMQX 5.0 or above

### Install gRPC and gRPC tools

Before running, we need to install the following dependencies related to gRPC:

```
python -m pip install grpcio
python -m pip install grpcio-tools
```

## Test it with EMQX

1. Make sure that EMQX is version 5.0 or above.
2. Run the ExHook server by the following command:
```
python exhook_server.py
```
3. Add an ExHook Server through the EMQX Dashboard and ensure that its address points to this example program. you can refer to the [Offcial Documentation](https://docs.emqx.com/en/enterprise/v5.1/extensions/exhook.html)

4. Observing this example program, it will print that it has received the `OnProviderLoaded` callback, indicating that they have successfully established a connection.

```
OnProviderLoaded: broker {
  version: "5.1.0"
  sysdescr: "EMQX"
  uptime: 67553173
  datetime: "2023-07-01T02:03:24.826755959+00:00"
}
...
```

5. Use an MQTT client, such as [MQTTX](https://mqttx.app/), to connect to EMQX and
   observe the output of this example program. e.g:

```
OnClientConnect: ...
OnClientAuthenticate: ...
OnSessionCreated: ...
OnClientConnected: ...
OnClientConnack: ...
```

At this point, the example program has successfully integrated with EMQX.

## Modify the exhook_server.py to deny all MQTT connecting request

In this section, we will take the `OnClientAuthenticate` callback as an example and
attempt to modify its implementation in `exhook_server.py` to deny some MQTT client
connections.

1. Modify the `OnClientAuthenticate` function in `exhook_server.py` to reject all
   client logins with the username "baduser".
   The complete implementation of the modified function is as follows:
```
def OnClientAuthenticate(self, request, context):
    print("OnClientAuthenticate:", request)
    clientinfo = request.clientinfo
    if clientinfo.username == "baduser":
        reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", bool_result=False)
    else:
        reply = exhook_pb2.ValuedResponse(type="STOP_AND_RETURN", bool_result=True)
    return reply
```

2. Shutdown and restart `exhook_server.py`.

3. Set the username of the MQTT client to "baduser" and connect to EMQX to test.

4. It can be observed that the client is unable to connect due to authentication failure, and the `exhook_server.py` will also output similar logs like this:
```
OnClientConnect: ...
OnClientAuthenticate: ...
OnClientConnack: ...
result_code: "not_authorized"
...
```

## Update the exhook.proto to latest version

Due to the inconsistency between the exhook.proto file used in this demo and the one included
in your installed version of EMQX, you may need to ensure their consistency.

For example, in EMQX v5.1.0, this file is located at
https://github.com/emqx/emqx/blob/v5.1.0/apps/emqx_exhook/priv/protos/exhook.proto

You need to manually update it to the `protos/exproto.proto` location and
regenerate code via the following command:

```
python -m grpc_tools.protoc -I./protos --python_out=. --grpc_python_out=. ./protos/exhook.proto
```

## References

- [gRPC.io Python Quick start](https://grpc.io/docs/languages/python/quickstart/)
