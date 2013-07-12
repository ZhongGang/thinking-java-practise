package com.icode.initialize;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-12
 * Time: 下午2:20
 */
public class StaticConstructor {

    private static int i = 12;
    private long j = 1234L;

    static {
        System.out.println("Initialize static block~~~");
    }

    public StaticConstructor() {
        System.out.println("Initialize constructor~~~");
    }

    public static void main(String[] args) {
        new StaticConstructor();
    }
}
