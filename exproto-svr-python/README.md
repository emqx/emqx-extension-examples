# ExProto Python Server

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

## Update to the latest exproto.proto


### Copy the exproto.proto

### Re-generate the codes

```
python -m grpc_tools.protoc -Iprotos --python_out=. --pyi_out=. --grpc_python_out=. protos/exproto.proto
```

## References

- [gRPC.io Python Quick start](https://grpc.io/docs/languages/python/quickstart/)
