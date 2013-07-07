package com.icode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-7
 * Time: 下午5:38
 */
public class DynamicProxy {

    public static void main(String[] args) throws Throwable {
        final Recordable recordable = new RecordableImpl();
        Recordable record = (Recordable) Proxy.newProxyInstance(recordable.getClass().getClassLoader(), new Class[]{Recordable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Before Record");
                return method.invoke(recordable, args);
            }
        });
        record.record();
    }

}
