package com.basic.thread.reentrantlock;

public class Run {

    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThread t1 = new MyThread(myService);
        MyThread t2 = new MyThread(myService);
        MyThread t3 = new MyThread(myService);
        MyThread t4 = new MyThread(myService);
        MyThread t5 = new MyThread(myService);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}
