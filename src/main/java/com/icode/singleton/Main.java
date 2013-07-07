package com.icode.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-7
 * Time: 下午9:34
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Set<Singleton> singletons = new HashSet<Singleton>();

        for (int i = 0; i < 20000; i++) {
            SingletonFetcher fetcher = new SingletonFetcher(singletons);
            fetcher.start();
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~" + "The size of set is " + singletons.size() + "~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
