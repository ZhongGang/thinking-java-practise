package com.icode.threadlocal;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-9-6
 * Time: 上午10:11
 */
public class NumberModification implements Runnable {
    private Number number;
    private Integer modificationAmount;

    public NumberModification(Number number, Integer modificationAmount) {
        assert number != null;
        this.number = number;
        this.modificationAmount = modificationAmount;
    }

    @Override
    public void run() {
        number.setAmount(modificationAmount);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new UnsupportedOperationException("Not yet implemented!");
        }
        System.out.println(Thread.currentThread().getName() + "[amount = " + number.getAmount() + "]");
    }

    public static void main(String[] args) {
        Number number = new Number();
        for (int i = 0; i < 10; i++) {
            NumberModification numberModification = new NumberModification(number, i);
            Thread thread = new Thread(numberModification);
            thread.start();
        }
    }
}
