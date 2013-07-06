package com.icode.map;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-5
 * Time: 下午11:53
 */
public class Key {


    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }
}
