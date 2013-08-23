package com.icode.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-23
 * Time: 下午11:55
 */
public class SyncServer {
    private Socket socket;

    public SyncServer(Socket socket) {
        this.socket = socket;
    }

    public void run() throws IOException, InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println(socket.toString() + i);
            Thread.sleep(1000);
        }
        InputStream inputStream = null;
        inputStream = socket.getInputStream();
        byte[] message = new byte[1024];
        inputStream.read(message);
        System.out.println(new String(message));
    }
}
