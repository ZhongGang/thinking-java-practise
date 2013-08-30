package com.icode.socket;

import java.io.IOException;
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

    public void asyncStart() throws IOException, InterruptedException {
        serverSocket = new ServerSocket(9999);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new AsyncServer(socket)).start();
        }
    }

    public void syncStart() throws IOException, InterruptedException {
        serverSocket = new ServerSocket(9999);
        while (true) {
            Socket socket = serverSocket.accept();
            new SyncServer(socket).run();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        server.syncStart();
    }
}
