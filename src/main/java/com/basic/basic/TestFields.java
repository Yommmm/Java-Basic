package com.basic.basic;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class TestFields {

    private int a; // 声明并初始化为0

    public void a(boolean is) {
        int a; // 声明
        if (is) {
            a = 1 / 2; // 初始化
            System.out.println(a);
        }
    }

}

interface TestI {

    static void print() {
        System.out.println(7777);
    }

    default void print(String a) {
        System.out.println(a);
    }

    void print2();

}
