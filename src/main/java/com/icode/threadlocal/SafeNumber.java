package com.icode.threadlocal;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-9-6
 * Time: 上午10:16
 */
public class SafeNumber {
    private ThreadLocal<Integer> amount = new ThreadLocal<Integer>();

    public Integer getAmount() {
        return amount.get();
    }

    public void setAmount(Integer amount) {
        this.amount.set(amount);
    }
}
