package com.basic.jvm.cmd;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class JpsThreadDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread() + "start sleep!");
                    TimeUnit.MINUTES.sleep(2);
                    System.out.println(Thread.currentThread() + "weak up!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

}
