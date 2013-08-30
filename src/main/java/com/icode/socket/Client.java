package com.icode.socket;

import java.io.*;
import java.net.InetAddress;
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
        this.socket = new Socket(InetAddress.getLocalHost(), 9999);
    }

    public void sendMessage(String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes());
    }

    public void readMessage() throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] message = new byte[1024];
        inputStream.read(message);
        System.out.println(new String(message));
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message = bufferedReader.readLine();
            for (int i = 0; i < 1; i++) {
                final Client client = new Client();
                client.sendMessage(message);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            client.readMessage();
                        } catch (IOException e) {
                            throw new UnsupportedOperationException("Not yet implemented!");
                        }
                    }
                }).start();

            }
        }
    }
}
