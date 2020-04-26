package com.basic.thread.volatiledemo;

import java.util.concurrent.TimeUnit;

/**
 * Volatile不能保证原子性的测试
 *
 * @author 85374
 * @date
 */
public class VolatileAtomic {

    public static void main(String[] args) throws InterruptedException {
        AtomicData atomicData = new AtomicData();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicData.add();
                }
            }, "AddThread" + i).start();
        }

        TimeUnit.SECONDS.sleep(5);
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }

        System.out.println(atomicData.atomic);
    }

}

class AtomicData {
    volatile int atomic;

    public void add() {
        this.atomic = this.atomic + 1;
    }
}

