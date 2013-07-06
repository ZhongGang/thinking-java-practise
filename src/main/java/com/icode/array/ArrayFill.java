package com.icode.array;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-5
 * Time: 下午6:26
 */
public class ArrayFill {

    private static int[] arrays = new int[10];

    public static int[] fill() {
        Arrays.fill(arrays, 2);
        return arrays;
    }

    public static void print() {
        fill();
        for (int array : arrays) {
            System.out.println(array);
        }
    }

    public static void sort() {
        fill();
        Arrays.sort(arrays);
    }
}
