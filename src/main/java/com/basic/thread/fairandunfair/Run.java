package com.basic.thread.fairandunfair;

public class Run {

    public static void main(String[] args) {
        final MyService myService = new MyService(true);

        final MyService myService1 = new MyService(false);

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("Fair Start " + Thread.currentThread().getName() + "开始运行");
                myService.serviceMethod();
            }
        };

        for (int i = 1; i <= 10; i++) {
            new Thread(runnable).start();
        }

        Runnable runnable1 = new Runnable() {

            @Override
            public void run() {
                System.out.println("Unfair Start " + Thread.currentThread().getName() + "开始运行");
                myService1.serviceMethod();
            }
        };

        for (int i = 1; i <= 10; i++) {
            new Thread(runnable1).start();
        }

    }

}
