package com.icode.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-7
 * Time: 下午9:30
 */
public class Singleton {
    private static Singleton singleton;

    private static Object lock = new Object();

    private Singleton() {

    }

    public static Singleton singleton() {
        synchronized (lock) {
            if (singleton == null) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new UnsupportedOperationException("Not yet implemented!");
                }
                singleton = new Singleton();
            }
            return singleton;
        }
    }
}
