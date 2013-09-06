package com.icode.threadlocal;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-9-6
 * Time: 上午10:18
 */
public class SafeNumberModification implements Runnable {
    private SafeNumber safeNumber;
    private Integer modificationNumber;

    public SafeNumberModification(SafeNumber safeNumber, Integer modificationNumber) {
        this.safeNumber = safeNumber;
        this.modificationNumber = modificationNumber;
    }

    @Override
    public void run() {
        safeNumber.setAmount(modificationNumber);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new UnsupportedOperationException("Not yet implemented!");
        }
        System.out.println(Thread.currentThread().getName() + "[amount = " + safeNumber.getAmount() + "]");
    }

    public static void main(String[] args) {
        SafeNumber safeNumber = new SafeNumber();
        for (int i = 0; i < 10; i++) {
            SafeNumberModification safeNumberModification = new SafeNumberModification(safeNumber, i);
            Thread thread = new Thread(safeNumberModification);
            thread.start();
        }
    }
}
