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
	log.Println("[LOG] 客户端 SOCKET 连接")
	// EMQX 认证
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
		log.Println("[LOG] EMQX 认证失败: ", err)
		return err
	}
	log.Println("[LOG] EMQX 认证成功: ", response)
	// 订阅主题
	subscribe := pb.SubscribeRequest{
		Topic: "test/1",
		Qos:   1,
		Conn:  recv.Conn,
	}
	response, err = client.Subscribe(in.Context(), &subscribe)
	if err != nil {
		log.Println("[LOG] 订阅主题失败: ", err)
		return err
	}
	log.Println("[LOG] 订阅主题成功: ", response)
	// 启动心跳检测
	timer := pb.TimerRequest{Conn: recv.Conn, Interval: 20, Type: pb.TimerType_KEEPALIVE}
	response, err = client.StartTimer(in.Context(), &timer)
	if err != nil {
		log.Println("[LOG] 启动心跳检测失败: ", err)
		return err
	}
	log.Println("[LOG] 启动心跳检测成功: ", response)
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
		log.Println("[LOG] 发布消息失败: ", err)
		return err
	}
	log.Println("[LOG] 客户端发送数据成功:", response.Code)
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
		log.Println("[LOG] 关闭连接失败: ", err)
		return err
	}
	log.Println("[LOG] 关闭连接成功")
	return nil
}

func (s *server) OnTimerTimeout(in pb.ConnectionHandler_OnTimerTimeoutServer) error {
	recv, err := in.Recv()
	if err != nil {
		log.Println("recv error:", err)
		return err
	}
	log.Println("[LOG] 客户端心跳超时")
	closeReq := pb.CloseSocketRequest{
		Conn: recv.Conn,
	}
	_, err = client.Close(in.Context(), &closeReq)
	log.Println("[LOG] 超时关闭连接")
	return nil
}

func (s *server) OnReceivedMessages(in pb.ConnectionHandler_OnReceivedMessagesServer) error {
	recv, err := in.Recv()
	if err != nil {
		log.Println("recv error:", err)
		return err
	}
	log.Println("[LOG] 客户端收到消息")
	sendReq := pb.SendBytesRequest{
		Conn:  recv.Conn,
		Bytes: recv.Messages[0].Payload,
	}
	response, err := client.Send(in.Context(), &sendReq)
	if err != nil {
		log.Println("[LOG] 发送消息失败: ", err)
		return err
	}
	log.Println("[LOG] 发送消息成功:", response.Code)
	return nil
}

func main() {
	lis, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	// 这里替换成你的EMQX的IP地址
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
