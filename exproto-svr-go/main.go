/*
 * Copyright 2023 EMQ Technologies Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Package main implements a server for Exproto ConnectionHandler service.
package main

import (
	"context"
	"flag"
	"fmt"
	"log"
	"net"

	pb "exproto-svr-go/protos"
	"google.golang.org/grpc"
)

var (
	port = flag.Int("port", 9001, "The server port")
)

// The client to send request to ExProto gateway
var client pb.ConnectionAdapterClient

type server struct {
	pb.UnimplementedConnectionUnaryHandlerServer
}

func (s *server) OnSocketCreated(ctx context.Context, in *pb.SocketCreatedRequest) (*pb.EmptySuccess, error) {
	log.Println("[callback] OnSocketCreated:", in)

	/* Using Authenticate to reigster your client to ExProto gateway
	 *
	 * Note1: If the clientid has been registered to ExProto gateway by other client, the old connection
	 *        will be closed, due to the clientid is unique in ExProto gateway
	 *
	 * Note2: The username and password can be used to authenticate the client, if the username and password
	 *        is not correct, the AuthenticateResponse.code will be set to 5 (PERMISSION_DENY)
	 */
	log.Println("[request ] Send AuthenticateRequest to register client to ExProto gateway: clientid=test")
	clientInfo := pb.ClientInfo{
		Clientid:  "test",
		Username:  "test",
		ProtoName: "exproto-echo-svr",
		ProtoVer:  "1",
	}
	auth := pb.AuthenticateRequest{
		Conn:       in.Conn,
		Clientinfo: &clientInfo,
		Password:   "password",
	}
	_, err := client.Authenticate(ctx, &auth)
	if err != nil {
		log.Println("[response] Authenticate failed: ", err)
		return nil, err
	}
	log.Println("[response] Authenticate successfully")
	// Subscribe to topic test/echo for this connection
	log.Println("[request ] Send SubscribeRequest to subscribe topic test/echo")
	subscribe := pb.SubscribeRequest{
		Conn:  in.Conn,
		Topic: "test/echo",
		Qos:   1,
	}
	_, err = client.Subscribe(ctx, &subscribe)
	if err != nil {
		log.Println("[response] Subscribe failed: ", err)
		return nil, err
	}
	log.Println("[response] Subscribe successfully")

	// Optional, start the keepalive timer to check the clients' active status
	// If the client is inactive for 60 seconds, the callback function OnTimerTimeout
	// will be called
	log.Println("[request ] Send TimerRequest to start keepalive timer in 60 seconds")
	timer := pb.TimerRequest{Conn: in.Conn, Interval: 20, Type: pb.TimerType_KEEPALIVE}
	_, err = client.StartTimer(ctx, &timer)
	if err != nil {
		log.Println("[response] Send TimerRequest failed: ", err)
		return nil, err
	}
	log.Println("[response] StartTimer successfully")

	return &pb.EmptySuccess{}, nil
}

func (s *server) OnSocketClosed(ctx context.Context, in *pb.SocketClosedRequest) (*pb.EmptySuccess, error) {
	log.Println("[callback] OnSocketClosed:", in)
	return &pb.EmptySuccess{}, nil
}

func (s *server) OnReceivedBytes(ctx context.Context, in *pb.ReceivedBytesRequest) (*pb.EmptySuccess, error) {
	log.Println("[callback] OnReceivedBytes:", in)

	// Publish the received message to topic test/echo
	log.Println("[request ] Send PublishRequest to publish message to topic test/echo")
	publish := pb.PublishRequest{
		Conn:    in.Conn,
		Topic:   "test/echo",
		Qos:     1,
		Payload: in.Bytes,
	}
	_, err := client.Publish(ctx, &publish)
	if err != nil {
		log.Println("[response] Publish failed: ", err)
		return nil, err
	}
	log.Println("[response] Publish successfully")

	return &pb.EmptySuccess{}, nil
}

func (s *server) OnTimerTimeout(ctx context.Context, in *pb.TimerTimeoutRequest) (*pb.EmptySuccess, error) {
	log.Println("[callback] OnTimerTimeout:", in)

	// Close the inactive connection
	log.Println("[request ] Send CloseSocketRequest to close the inactive connection")
	close := pb.CloseSocketRequest{
		Conn: in.Conn,
	}
	_, err := client.Close(ctx, &close)
	if err != nil {
		log.Println("[response] Close failed: ", err)
		return nil, err
	}
	log.Println("[response] Close successfully")

	return &pb.EmptySuccess{}, nil
}

func (s *server) OnReceivedMessages(ctx context.Context, in *pb.ReceivedMessagesRequest) (*pb.EmptySuccess, error) {
	log.Println("[callback] OnReceivedMessages:", in)

	var message = in.Messages[0]

	// Send the received message back to the client
	log.Println("[request ] Send SendBytesRequest to send message back to the client")
	send := pb.SendBytesRequest{
		Conn:  in.Conn,
		Bytes: message.Payload,
	}
	_, err := client.Send(ctx, &send)
	if err != nil {
		log.Println("[response] Send failed: ", err)
		return nil, err
	}
	log.Println("[response] Send successfully")

	return &pb.EmptySuccess{}, nil
}

func main() {
	// Initial the gRPC client to connect to ConnectionAdapter of ExProto gateway
	conn, err := grpc.Dial("127.0.0.1:9100", grpc.WithInsecure())
	if err != nil {
		log.Fatalf("did not connect:", err)
	}
	defer conn.Close()
	client = pb.NewConnectionAdapterClient(conn)

	// Start the gRPC server to listen the callback from ExProto gateway
	flag.Parse()
	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", *port))
	if err != nil {
		log.Fatalf("failed to listen:", err)
	}
	s := grpc.NewServer()
	pb.RegisterConnectionUnaryHandlerServer(s, &server{})

	// Print the tips for the demo server
	log.Println("Server listening at", lis.Addr())
	log.Println("Note: This demo server only works for emqx 5.1.0 or higher version.")
	log.Println("      It will echo the received message back to the client")
	log.Println("Note: Please make sure the ConnectionAdapter of ExProto gateway is")
	log.Println("      running on  127.0.0.1:9100")
	log.Println("")
	log.Println("ConnectionUnaryHandler started successfully, listening on 9001")
	log.Println("")
	log.Println("Tips: If the Listener of EMQX ExProto gateway listen on 7993:")
	log.Println("      You can use the telnet to test the server, for example:")
	log.Println("")
	log.Println("      telnet 127.0.0.1 7993")
	log.Println("")

	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve:", err)
	}
}
