package com.icode.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-7
 * Time: 下午5:35
 */
public class RecordableImpl implements Recordable {

    @Override
    public void record() {
        System.out.println("Record");
    }
}
