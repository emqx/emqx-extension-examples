# ExProto Python Server

This example is based on the Exroto Gateway of EMQX v5.1.
It implements the function of message echo to demonstrate how all functions work.


## Prerequisites 

- Python 3.7 or higher
- pip version 9.0.1 or higher
- EMQX 5.1.0 or higher

## Quick start

### Install gRPC and gRPC tools

```bash
python -m pip install grpcio
python -m pip install grpcio-tools
```

### Start ExProto gateway and the gRPC server

1. Make sure you are running EMQX v5.1.0 or above and start the ExProto Gateway with default
   configuration through EMQX Dashboard.

2. Start the gRPC Server using the following command on the same machine as EMQX.
   ```
   python exproto_server.py
   ```
3. Use the "telnet" command to simulate a TCP client connecting to the ExProto Gateway's 7993
   listener port. i.e:

   ```
   telnet 127.0.0.1 7993
   ```

4. When trying to type any character in the telnet command, we will find that the server outputs
   it as is, indicating that the entire example has run successfully. For example:

   ```
   $ telnet 127.0.0.1 7993
   Trying 127.0.0.1...
   Connected to 127.0.0.1.
   Escape character is '^]'.
   Hi, this is tcp client!
   Hi, this is tcp client!
   ```

Finally, you can compare the logs output by the gRPC program with the ExProto.java code
and understand how it works.


## Update to the latest exproto.proto

Due to the inconsistency between the exproto.proto file used in this demo and the one included
in your installed version of EMQX, you may need to ensure their consistency.

For example, in EMQX v5.1.0, this file is located at
https://github.com/emqx/emqx/blob/v5.1.0/apps/emqx_gateway_exproto/priv/protos/exproto.proto

You need to manually update it to the `protos/exproto.proto` location and
regenerate code via the following command:

```
python -m grpc_tools.protoc -Iprotos --python_out=. --pyi_out=. --grpc_python_out=. protos/exproto.proto
```

## References

- [gRPC.io Python Quick start](https://grpc.io/docs/languages/python/quickstart/)
