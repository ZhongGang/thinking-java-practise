package com.icode.aio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-25
 * Time: 上午11:00
 */
public class Server {
    private AsynchronousServerSocketChannel serverSocketChannel;

    public Server() throws IOException {
        SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 9999);
        serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(socketAddress);
    }

    public void start() throws ExecutionException, InterruptedException, IOException {
        while (true) {
            Future<AsynchronousSocketChannel> future = serverSocketChannel.accept();
            AsynchronousSocketChannel socketChannel = future.get();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear();
            socketChannel.read(buffer);
            buffer.flip();
            System.out.println(socketChannel.getRemoteAddress().toString() + " said " + new String(buffer.array()));
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        Server server = new Server();
        server.start();
    }
}
