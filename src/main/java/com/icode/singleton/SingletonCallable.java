package com.icode.singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-15
 * Time: 上午12:12
 */
public class SingletonCallable implements Callable {
    private Set<Singleton> singletons;

    public SingletonCallable(Set<Singleton> singletons) {
        this.singletons = singletons;
    }

    @Override
    public Object call() throws Exception {
        Singleton singleton = Singleton.singleton();
        singletons.add(singleton);
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        Set<Singleton> singletons = new HashSet<Singleton>();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 20000; i++) {
            SingletonCallable callable = new SingletonCallable(singletons);
            executorService.submit(callable);
        }

        Thread.sleep(10000);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~" + "The size of set is " + singletons.size() + "~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
