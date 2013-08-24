package com.icode.datagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-22
 * Time: 下午2:30
 */
public class Client {
    private DatagramSocket socket;

    public Client() throws IOException {
        SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 9998);
        this.socket = new DatagramSocket(socketAddress);
    }

    public void sendMessage(String message) throws IOException {
        SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 9999);
        byte[] content = message.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(content, content.length, socketAddress);
        socket.send(datagramPacket);
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message = bufferedReader.readLine();
            Client client = new Client();
            client.sendMessage(message);
        }
    }
}
