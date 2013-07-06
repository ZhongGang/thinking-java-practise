package com.icode.map;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-6
 * Time: 上午12:20
 */
public class StringHashCode {

    public static void main(String[] args) {
        String value = new String("hello hello");
        String[] values = value.split(" ");
        for (String s : values) {
            System.out.println(s.hashCode());
        }
    }
}
