package com.icode.threadlocal;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-9-6
 * Time: 上午10:35
 */
public class ISafeNumber {
    private IThreadLocal<Integer> amount = new IThreadLocal<Integer>();

    public Integer getAmount() {
        return this.amount.get();
    }

    public void setAmount(Integer amount) {
        this.amount.set(amount);
    }
}
