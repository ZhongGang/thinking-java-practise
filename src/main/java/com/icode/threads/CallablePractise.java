package com.icode.threads;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-15
 * Time: 下午2:44
 */
public class CallablePractise implements Callable<Integer> {
    private static int COUNT = 0;

    @Override
    public Integer call() throws Exception {
        COUNT += 1;
        return COUNT;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int totalCount = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            Future<Integer> result = executorService.submit(new CallablePractise());
            totalCount += result.get();
        }

        executorService.shutdown();

        System.out.println(totalCount);
    }
}
