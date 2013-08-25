package com.icode.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-25
 * Time: 上午11:40
 */
public class Server {
    private ServerSocketChannel serverSocketChannel;

    public Server() throws IOException {
        SocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 9999);
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(socketAddress);
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int select = selector.select();
            if (select == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                iterator.remove();
                if (next.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) next.channel();
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    String message = new String(buffer.array());
                    System.out.println(message);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}
