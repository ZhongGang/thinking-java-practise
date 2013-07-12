package com.icode.initialize;

import com.icode.finalize.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-7
 * Time: 下午7:08
 */
public class Main {

    public static void main(String[] args) {
        Initialize initialize = new Initialize();
        initialize.print();


        new DataSource();
    }
}
