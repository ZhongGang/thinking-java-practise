package com.icode.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-22
 * Time: 下午2:34
 */
public class Server {
    private DatagramSocket serverSocket;

    public void start() throws IOException {
        serverSocket = new DatagramSocket(9999);
        while (true) {
            byte[] message = new byte[1024];
            DatagramPacket packet = new DatagramPacket(message, 1024);
            serverSocket.receive(packet);
            System.out.println(new String(message));
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }
}
