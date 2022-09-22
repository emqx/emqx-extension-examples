package main

import (
	"log"
	"net"

	"google.golang.org/grpc"

	pb "exproto-svr-go/protos"
)

const (
	port = ":9001"
)

type server struct {
	pb.ConnectionHandlerServer
}

var client pb.ConnectionAdapterClient

func (s *server) OnSocketCreated(in pb.ConnectionHandler_OnSocketCreatedServer) error {
	recv, err := in.Recv()
	if err != nil {
		log.Println("recv error:", err)
		return err
	}
	log.Println("[LOG] client connected")
	// EMQX Auth
	clientInfo := pb.ClientInfo{
		Clientid: "client_test",
		Username: "username",
	}
	auth := pb.AuthenticateRequest{
		Clientinfo: &clientInfo,
		Password:   "password",
		Conn:       recv.Conn,
	}
	response, err := client.Authenticate(in.Context(), &auth)
	if err != nil {
		log.Println("[LOG] client auth failed: ", err)
		return err
	}
	log.Println("[LOG] client auth success: ", response)
	// EMQX Subscribe Topic
	subscribe := pb.SubscribeRequest{
		Topic: "test/1",
		Qos:   1,
		Conn:  recv.Conn,
	}
	response, err = client.Subscribe(in.Context(), &subscribe)
	if err != nil {
		log.Println("[LOG] client subscribe failed: ", err)
		return err
	}
	log.Println("[LOG] client subscribe success: ", response)
	// Start Heartbeat
	timer := pb.TimerRequest{Conn: recv.Conn, Interval: 20, Type: pb.TimerType_KEEPALIVE}
	response, err = client.StartTimer(in.Context(), &timer)
	if err != nil {
		log.Println("[LOG] start heartbeat failed: ", err)
		return err
	}
	log.Println("[LOG] start heartbeat success: ", response)
	return nil
}

func (s *server) OnReceivedBytes(in pb.ConnectionHandler_OnReceivedBytesServer) error {
	recv, err := in.Recv()
	if err != nil {
		log.Println("recv error:", err)
		return err
	}
	publish := pb.PublishRequest{
		Conn:    recv.Conn,
		Topic:   "test/2",
		Qos:     1,
		Payload: recv.GetBytes(),
	}
	response, err := client.Publish(in.Context(), &publish)
	if err != nil {
		log.Println("[LOG] publish message failed: ", err)
		return err
	}
	log.Println("[LOG] publish message success: ", response.Code)
	return nil
}

func (s *server) OnSocketClosed(in pb.ConnectionHandler_OnSocketClosedServer) error {
	recv, err := in.Recv()
	if err != nil {
		log.Println("recv error:", err)
		return err
	}
	closeReq := pb.CloseSocketRequest{
		Conn: recv.Conn,
	}
	_, err = client.Close(in.Context(), &closeReq)
	if err != nil {
		log.Println("[LOG] close connection failed: ", err)
		return err
	}
	log.Println("[LOG] close connection success")
	return nil
}

func (s *server) OnTimerTimeout(in pb.ConnectionHandler_OnTimerTimeoutServer) error {
	recv, err := in.Recv()
	if err != nil {
		log.Println("recv error:", err)
		return err
	}
	log.Println("[LOG] client heartbeat timeout")
	closeReq := pb.CloseSocketRequest{
		Conn: recv.Conn,
	}
	_, err = client.Close(in.Context(), &closeReq)
	log.Println("[LOG] close connection success")
	return nil
}

func (s *server) OnReceivedMessages(in pb.ConnectionHandler_OnReceivedMessagesServer) error {
	recv, err := in.Recv()
	if err != nil {
		log.Println("recv error:", err)
		return err
	}
	log.Println("[LOG] client received message")
	sendReq := pb.SendBytesRequest{
		Conn:  recv.Conn,
		Bytes: recv.Messages[0].Payload,
	}
	response, err := client.Send(in.Context(), &sendReq)
	if err != nil {
		log.Println("[LOG] send message failed: ", err)
		return err
	}
	log.Println("[LOG] send message success: ", response.Code)
	return nil
}

func main() {
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	// Replace this with the IP address of your EMQX server
	conn, err := grpc.Dial("127.0.0.1:9100", grpc.WithInsecure())
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()
	client = pb.NewConnectionAdapterClient(conn)
	s := grpc.NewServer()
	pb.RegisterConnectionHandlerServer(s, &server{})
	log.Println("Started gRPC server on ::9001")
	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
