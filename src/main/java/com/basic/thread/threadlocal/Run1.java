package com.basic.thread.threadlocal;

public class Run1 {

    private static ThreadLocal<String> t1 = new ThreadLocal<>();

    public static void main(String[] args) {
        if (null == t1.get()) {
            System.out.println("null");
            t1.set("my value");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }

}
