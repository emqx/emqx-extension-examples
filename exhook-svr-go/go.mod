module emqx.io/grpc/exhook

go 1.11

replace emqx.io/grpc/exhook => ./

require (
	github.com/golang/protobuf v1.5.0
	google.golang.org/grpc v1.36.0
	google.golang.org/grpc/cmd/protoc-gen-go-grpc v1.2.0 // indirect
	google.golang.org/protobuf v1.27.1
)
