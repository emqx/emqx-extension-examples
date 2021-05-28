package main

import (
	"context"
	"log"
	"net"

	pb "emqx.io/grpc/exhook/protobuf"
	utils "emqx.io/grpc/exhook/utils"
	"google.golang.org/grpc"
)

const (
	port = ":9000"
)

var cnter *utils.Counter = utils.NewCounter(0, 100)

// server is used to implement emqx_exhook_v1.s *server
type server struct {
	pb.UnimplementedHookProviderServer
}

// HookProviderServer callbacks

func (s *server) OnProviderLoaded(ctx context.Context, in *pb.ProviderLoadedRequest) (*pb.LoadedResponse, error) {
	cnter.Count(1)
	hooks := []*pb.HookSpec{
		&pb.HookSpec{Name: "client.connect"},
		&pb.HookSpec{Name: "client.connack"},
		&pb.HookSpec{Name: "client.connected"},
		&pb.HookSpec{Name: "client.disconnected"},
		&pb.HookSpec{Name: "client.authenticate"},
		&pb.HookSpec{Name: "client.check_acl"},
		&pb.HookSpec{Name: "client.subscribe"},
		&pb.HookSpec{Name: "client.unsubscribe"},
		&pb.HookSpec{Name: "session.created"},
		&pb.HookSpec{Name: "session.subscribed"},
		&pb.HookSpec{Name: "session.unsubscribed"},
		&pb.HookSpec{Name: "session.resumed"},
		&pb.HookSpec{Name: "session.discarded"},
		&pb.HookSpec{Name: "session.takeovered"},
		&pb.HookSpec{Name: "session.terminated"},
		&pb.HookSpec{Name: "message.publish"},
		&pb.HookSpec{Name: "message.delivered"},
		&pb.HookSpec{Name: "message.acked"},
		&pb.HookSpec{Name: "message.dropped"},
	}
	return &pb.LoadedResponse{Hooks: hooks}, nil
}

func (s *server) OnProviderUnloaded(ctx context.Context, in *pb.ProviderUnloadedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnClientConnect(ctx context.Context, in *pb.ClientConnectRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnClientConnack(ctx context.Context, in *pb.ClientConnackRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnClientConnected(ctx context.Context, in *pb.ClientConnectedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnClientDisconnected(ctx context.Context, in *pb.ClientDisconnectedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnClientAuthenticate(ctx context.Context, in *pb.ClientAuthenticateRequest) (*pb.ValuedResponse, error) {
	cnter.Count(1)
	reply := &pb.ValuedResponse{}
	reply.Type = pb.ValuedResponse_STOP_AND_RETURN
	reply.Value = &pb.ValuedResponse_BoolResult{BoolResult: true}
	return reply, nil
}

func (s *server) OnClientCheckAcl(ctx context.Context, in *pb.ClientCheckAclRequest) (*pb.ValuedResponse, error) {
	cnter.Count(1)
	reply := &pb.ValuedResponse{}
	reply.Type = pb.ValuedResponse_STOP_AND_RETURN
	reply.Value = &pb.ValuedResponse_BoolResult{BoolResult: true}
	return &pb.ValuedResponse{}, nil
}

func (s *server) OnClientSubscribe(ctx context.Context, in *pb.ClientSubscribeRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnClientUnsubscribe(ctx context.Context, in *pb.ClientUnsubscribeRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnSessionCreated(ctx context.Context, in *pb.SessionCreatedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}
func (s *server) OnSessionSubscribed(ctx context.Context, in *pb.SessionSubscribedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnSessionUnsubscribed(ctx context.Context, in *pb.SessionUnsubscribedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnSessionResumed(ctx context.Context, in *pb.SessionResumedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnSessionDiscarded(ctx context.Context, in *pb.SessionDiscardedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnSessionTakeovered(ctx context.Context, in *pb.SessionTakeoveredRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnSessionTerminated(ctx context.Context, in *pb.SessionTerminatedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnMessagePublish(ctx context.Context, in *pb.MessagePublishRequest) (*pb.ValuedResponse, error) {
	cnter.Count(1)
	in.Message.Payload = []byte("hardcode payload by exhook-svr-go :)")
	reply := &pb.ValuedResponse{}
	reply.Type = pb.ValuedResponse_STOP_AND_RETURN
	reply.Value = &pb.ValuedResponse_Message{Message: in.Message}
	return reply, nil
}

func (s *server) OnMessageDelivered(ctx context.Context, in *pb.MessageDeliveredRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnMessageDropped(ctx context.Context, in *pb.MessageDroppedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnMessageAcked(ctx context.Context, in *pb.MessageAckedRequest) (*pb.EmptySuccess, error) {
	cnter.Count(1)
	return &pb.EmptySuccess{}, nil
}

func main() {
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	s := grpc.NewServer()
	pb.RegisterHookProviderServer(s, &server{})
	log.Println("Started gRPC server on ::9000")
	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
