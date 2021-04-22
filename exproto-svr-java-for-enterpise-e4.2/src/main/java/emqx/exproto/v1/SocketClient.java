package emqx.exproto.v1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;


public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 7993);
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            // 模拟数据
            out.write("[100,10]".getBytes());
            out.flush();
            outToServer.flush();
            outToServer.close();
            out.close();
            client.close();
            System.out.println("Message send success:" + new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
