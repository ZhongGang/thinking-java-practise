package com.icode.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-9-6
 * Time: 上午10:33
 */
public class IThreadLocal<T> {
    private Map<Thread, T> value = Collections.synchronizedMap(new HashMap<Thread, T>());

    public T get() {
        Thread currentThread = Thread.currentThread();
        return value.get(currentThread);
    }

    public void set(T t) {
        Thread currentThread = Thread.currentThread();
        value.put(currentThread, t);
    }
}
