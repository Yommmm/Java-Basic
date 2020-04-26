package com.basic.thread.volatiledemo;

import java.util.concurrent.TimeUnit;

/**
 * volatile线程可见性测试
 *
 * @author 85374
 * @date
 */
public class VolatileVisibility {

    public static void main(String[] args) {
        VisibilityData data = new VisibilityData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in!");

            try {
                TimeUnit.SECONDS.sleep(2);
                data.add();
                System.out.println(Thread.currentThread().getName() + "update number, value: " + data.visibility);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "Visibility Thread").start();


        while (data.visibility == 0) {
//            System.out.println("while");
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
        System.out.println(Thread.currentThread().getName() + "\t mission is over，main get number is:" + data.visibility);
    }

}

class VisibilityData {

    // 陷入死循环
    int visibility;

    // 不陷入死循环
//    volatile int visibility;

    public void add() {
        this.visibility = this.visibility + 1;
    }
}
