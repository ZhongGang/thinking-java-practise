package com.icode.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-22
 * Time: 下午2:30
 */
public class Client {
    private Socket socket;

    public Client() throws IOException {
        this.socket = new Socket("127.0.0.1", 9999);
    }

    public void sendMessage(String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes());
    }

    public void readMessage() throws IOException {
        InputStream inputStream = socket.getInputStream();
        throw new UnsupportedOperationException("Not yet implemented!");
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
