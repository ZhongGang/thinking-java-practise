package com.icode.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-22
 * Time: 下午2:34
 */
public class Server {
    private ServerSocket serverSocket;

    public void start() throws IOException {
        serverSocket = new ServerSocket(9999);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] message = new byte[1024];
            inputStream.read(message);
            System.out.println(new String(message));
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }
}
