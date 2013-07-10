package com.icode.cycle;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-10
 * Time: 下午11:19
 */
public class BicycleFactory extends AbstractCycleFactory {

    @Override
    public Bicycle cycle() {
        return new Bicycle();
    }
}
