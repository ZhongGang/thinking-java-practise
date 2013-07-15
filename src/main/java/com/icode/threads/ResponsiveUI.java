package com.icode.threads;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-15
 * Time: 下午3:04
 */
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            new ResponsiveUI();
            System.in.read();
            System.out.println(d);
        }
    }
}
