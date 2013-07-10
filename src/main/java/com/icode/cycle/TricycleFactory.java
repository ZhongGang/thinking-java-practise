package com.icode.cycle;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-10
 * Time: 下午11:19
 */
public class TricycleFactory extends AbstractCycleFactory {

    @Override
    public Tricycle cycle() {
        return new Tricycle();
    }
}
