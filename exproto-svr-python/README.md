# ExProto Python Server

This example is based on the Exroto Gateway of EMQX v5.1.
It implements the function of message echo to demonstrate how all functions work.


## Prerequisites 

- Python 3.7 or higher
- pip version 9.0.1 or higher
- EMQX 5.1.0 or higher

## Quick start

Install gRPC and gRPC tools

```bash
python -m pip install grpcio
python -m pip install grpcio-tools
```

### Have a test

1. Start the ExProto gateway in default configurations

2. Start the grpc server

```
python exproto_server.py
```

3. Send message to ExProto tcp listener via `telnent`,
   and you will receive the echo messages automatically. i.e:

```
$ telnet 127.0.0.1 7993
Trying 127.0.0.1...
Connected to 127.0.0.1.
Escape character is '^]'.
Hi, this is tcp client!
Hi, this is tcp client!
```

## Update to the latest exproto.proto

Due to the fact that the exproto.proto file used in this demo is not kept in sync with the emqx repository
in real time.
You need to manually update the `protos/exproto.proto` file and then use the following command to regenerate the code:

```
python -m grpc_tools.protoc -Iprotos --python_out=. --pyi_out=. --grpc_python_out=. protos/exproto.proto
```

## References

- [gRPC.io Python Quick start](https://grpc.io/docs/languages/python/quickstart/)
