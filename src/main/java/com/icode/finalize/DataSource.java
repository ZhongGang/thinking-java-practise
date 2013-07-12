package com.icode.finalize;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-7
 * Time: 下午6:49
 */
public class DataSource {
    protected String url;
    protected Class<?> driverClassName;
    protected String username;
    protected String password;


    public void finalize() {
        System.out.println("Free the memory~");
    }

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        new DataSource();
        new DataSource();

        System.gc();
    }
}

