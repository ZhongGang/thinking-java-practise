package com.icode.threadlocal;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-9-6
 * Time: 上午10:36
 */
public class ISafeNumberModification implements Runnable {
    private ISafeNumber iSafeNumber;
    private Integer modificationAmount;

    public ISafeNumberModification(ISafeNumber iSafeNumber, Integer modificationAmount) {
        assert iSafeNumber != null;
        this.iSafeNumber = iSafeNumber;
        this.modificationAmount = modificationAmount;
    }

    @Override
    public void run() {
        iSafeNumber.setAmount(modificationAmount);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new UnsupportedOperationException("Not yet implemented!");
        }
        System.out.println(Thread.currentThread().getName() + "[amount = " + iSafeNumber.getAmount() + "]");
    }

    public static void main(String[] args) {
        ISafeNumber iSafeNumber = new ISafeNumber();
        for (int i = 0; i < 10; i++) {
            ISafeNumberModification iSafeNumberModification = new ISafeNumberModification(iSafeNumber, i);
            Thread thread = new Thread(iSafeNumberModification);
            thread.start();
        }
    }
}
