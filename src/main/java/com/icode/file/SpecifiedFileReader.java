package com.icode.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-6
 * Time: 下午2:30
 */
public class SpecifiedFileReader {

    private String filePath;

    public SpecifiedFileReader(String filePath) {
        this.filePath = filePath;
    }

    public void read() throws IOException {
        FileReader in = FileReaderCreator.create(filePath);
        BufferedReader reader = new BufferedReader(in);
        StringBuilder builder = new StringBuilder();
        String content = "";
        while ((content = reader.readLine()) != null) {
            builder.append(content).append("\n");
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) throws IOException {
        SpecifiedFileReader reader = new SpecifiedFileReader("G:\\Test.txt");
        reader.read();
    }
}
