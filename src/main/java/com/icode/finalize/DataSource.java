package com.icode.finalize;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-7
 * Time: 下午6:49
 */
public class DataSource {
    private String url;
    private Class<?> driverClassName;
    private String username;
    private String password;


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

