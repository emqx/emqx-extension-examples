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

## Quick start

1. Make sure you are running EMQX v5.1.0 or above and start the ExProto Gateway with default
   configuration through EMQX Dashboard.

2. Start the gRPC Server using the following command on the same machine as EMQX.
   ```
   go run main.go
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
protoc --go_out=. --go_opt=paths=source_relative \
    --go-grpc_out=. --go-grpc_opt=paths=source_relative \
    protos/exproto.proto
```

## References

- [gRPC.io Go Quick start](https://grpc.io/docs/languages/go/quickstart/)
