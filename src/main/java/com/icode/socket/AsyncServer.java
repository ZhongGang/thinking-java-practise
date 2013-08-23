package com.icode.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-23
 * Time: 下午11:52
 */
public class AsyncServer implements Runnable {
    private Socket socket;

    public AsyncServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(socket.toString() + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new UnsupportedOperationException("Not yet implemented!");
            }
        }
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            throw new UnsupportedOperationException("Not yet implemented!");
        }
        byte[] message = new byte[1024];
        try {
            inputStream.read(message);
        } catch (IOException e) {
            throw new UnsupportedOperationException("Not yet implemented!");
        }
        System.out.println(new String(message));
    }
}
