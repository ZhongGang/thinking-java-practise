package com.icode.cycle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-7
 * Time: 下午8:03
 */
public class CycleFactory {

    private static List<CycleCreatable> creatables = new ArrayList<CycleCreatable>();

    static {
        creatables.add(new UnicycleCreator());
        creatables.add(new BicycleCreator());
        creatables.add(new TricycleCreator());
    }

    public static Cycle generate(CycleType type) {
        for (CycleCreatable creatable : creatables) {
            if (creatable.support(type)) {
                return creatable.create();
            }
        }
        throw new UnsupportedOperationException("Not yet implemented!");
    }

    private interface CycleCreatable {

        boolean support(CycleType type);

        Cycle create();
    }

    private static class BicycleCreator implements CycleCreatable {

        @Override
        public boolean support(CycleType type) {
            return type == CycleType.BICYCLE;
        }

        @Override
        public Cycle create() {
            return new Bicycle();
        }
    }

    private static class TricycleCreator implements CycleCreatable {

        @Override
        public boolean support(CycleType type) {
            return type == CycleType.TRICYCLE;
        }

        @Override
        public Cycle create() {
            return new Tricycle();
        }
    }

    private static class UnicycleCreator implements CycleCreatable {

        @Override
        public boolean support(CycleType type) {
            return type == CycleType.UNICYCLE;
        }

        @Override
        public Cycle create() {
            return new Unicycle();
        }
    }

}
