# ExProto Go Demo server

## Prerequisites

- Go, any one of the three latest major releases of Go.
  For installation instructions, see Go’s [Getting Started](https://go.dev/doc/install) guide.

- Protocol buffer compiler, protoc.
  For installation instructions, see [Protocol Buffer Compiler Installation](https://grpc.io/docs/protoc-installation/)

- Go plugins for the protocol compiler:
  Install the protocol compiler plugins for Go using the following commands:
  ```
  $ go install google.golang.org/protobuf/cmd/protoc-gen-go@v1.28
  $ go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@v1.2
  ```
  Update your PATH so that the protoc compiler can find the plugins:
  ```
  $ export PATH="$PATH:$(go env GOPATH)/bin"
  ```

## Have a tests

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
protoc --go_out=. --go_opt=paths=source_relative \
    --go-grpc_out=. --go-grpc_opt=paths=source_relative \
    protos/exproto.proto
```

## References

- [gRPC.io Go Quick start](https://grpc.io/docs/languages/go/quickstart/)
