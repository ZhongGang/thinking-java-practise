package com.icode.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-15
 * Time: 下午2:22
 */
public class ThreadPractiseOne implements Runnable {
    private static int THREAD_COUNT = 0;

    public ThreadPractiseOne() {
        System.out.println("Thread " + THREAD_COUNT + " is starting~~~~~~");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Thread " + THREAD_COUNT + " Print message " + i);
            Thread.yield();
        }
        System.out.println("Thread " + THREAD_COUNT + " is ending~~~~~~");

        THREAD_COUNT += 1;
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new ThreadPractiseOne());
        executorService.shutdown();
    }
}
