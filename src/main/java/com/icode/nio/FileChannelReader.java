package com.icode.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-6
 * Time: 下午4:03
 */
public class FileChannelReader {

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("G:\\Test.txt");
        FileChannel channel = in.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);


        FileOutputStream out = new FileOutputStream("G:\\TestOut.txt");
        FileChannel outChannel = out.getChannel();

        while (channel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
    }
}
