package com.icode.proxy;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-7
 * Time: 下午5:36
 */
public class RecordProxyImpl implements Recordable {
    private Recordable recordable;

    public RecordProxyImpl(Recordable recordable) {
        this.recordable = recordable;
    }

    @Override
    public void record() {
        System.out.println("Before Record");
        recordable.record();
        System.out.println("After Record");
    }


    public static void main(String[] args) {
        Recordable recordable = new RecordableImpl();
        recordable.record();

        recordable = new RecordProxyImpl(recordable);
        recordable.record();
    }
}
