package com.icode.singleton;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-7
 * Time: 下午9:33
 */
public class SingletonFetcher extends Thread {
    private Set<Singleton> singletons;

    public SingletonFetcher(Set<Singleton> singletons) {
        this.singletons = singletons;
    }

    @Override
    public void run() {
        Singleton singleton = Singleton.singleton();
        singletons.add(singleton);
//        System.out.println(Thread.currentThread().getName() + " added the singleton to the set!");
    }
}
