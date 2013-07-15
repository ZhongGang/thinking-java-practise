package com.icode.runtime;

import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-14
 * Time: 下午10:00
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("The size of processor is " + Runtime.getRuntime().availableProcessors());
        System.out.println("The total memory is " + Runtime.getRuntime().totalMemory());
        System.out.println("The free memory is " + Runtime.getRuntime().freeMemory());


        byte[] bytes = "钟刚".getBytes(Charset.forName("UTF-8"));
        for (byte aByte : bytes) {
            System.out.print(aByte + " ");
        }
    }
}
