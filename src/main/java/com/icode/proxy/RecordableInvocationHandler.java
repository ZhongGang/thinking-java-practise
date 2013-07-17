package com.icode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-17
 * Time: 下午3:27
 */
public class RecordableInvocationHandler implements InvocationHandler {

    private Recordable recordable;

    public RecordableInvocationHandler(Recordable recordable) {
        this.recordable = recordable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before Record");
        return method.invoke(recordable, args);
    }
}
