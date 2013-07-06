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
 * Time: 下午6:53
 */
public class FileCopyUtil {

    public static void copy(String sourceFile, String destinationFile) throws IOException {
        FileInputStream in = new FileInputStream(sourceFile);
        FileChannel readChannel = in.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        FileOutputStream out = new FileOutputStream(destinationFile);
        FileChannel writeChannel = out.getChannel();


        writeChannel.transferFrom(readChannel, 0, readChannel.size());

        while (readChannel.read(buffer) != -1) {
            buffer.flip();
            writeChannel.write(buffer);
            buffer.clear();
        }
    }


    public static void transferFrom(String sourceFile, String destinationFile) throws IOException {
        FileInputStream in = new FileInputStream(sourceFile);
        FileChannel readChannel = in.getChannel();

        FileOutputStream out = new FileOutputStream(destinationFile);
        FileChannel writeChannel = out.getChannel();

        writeChannel.transferFrom(readChannel, 0, readChannel.size());
    }


    public static void transferTo(String sourceFile, String destinationFile) throws IOException {
        FileInputStream in = new FileInputStream(sourceFile);
        FileChannel readChannel = in.getChannel();

        FileOutputStream out = new FileOutputStream(destinationFile);
        FileChannel writeChannel = out.getChannel();

        readChannel.transferTo(0, readChannel.size(), writeChannel);
    }


    public static void main(String[] args) throws IOException {
        FileCopyUtil.transferFrom("G:\\Test.txt", "G:\\TestOut.txt");
        FileCopyUtil.transferTo("G:\\Test.txt", "G:\\TestOut.txt");
        FileCopyUtil.copy("G:\\Test.txt", "G:\\TestOut.txt");
    }
}
