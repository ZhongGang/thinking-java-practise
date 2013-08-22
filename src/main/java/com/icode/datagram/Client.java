package com.icode.datagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-22
 * Time: 下午2:30
 */
public class Client {
    private DatagramSocket socket;

    public Client() throws IOException {
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9999);
        this.socket = new DatagramSocket(socketAddress);
    }

    public void sendMessage(String message) throws IOException {
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9999);
        DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(), 20, socketAddress);
        socket.send(datagramPacket);
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
