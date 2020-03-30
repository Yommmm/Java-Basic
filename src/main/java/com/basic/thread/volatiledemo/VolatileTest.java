package com.basic.thread.volatiledemo;

public class VolatileTest {
    int a = 1;
    int b = 2;

    public void change() {
        a = 3;
        b = a;
    }

    public void print() {
        if (b != 3) {
            System.out.println("b=" + b + ";a=" + a);
        }
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.change();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.print();
                }
            }).start();
        }
    }
}