package com.basic.thread.volatiledemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

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
                    atomicData.addValue();
                    atomicData.add();
                }
            }, "AddThread" + i).start();
        }

        TimeUnit.SECONDS.sleep(5);
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }

        System.out.println(atomicData.value.get());
    }

}

class AtomicData {

    AtomicInteger value = new AtomicInteger(0);
    volatile int atomic;

    public void addValue() {
        value.getAndAdd(1);
//        value.set(value.get() + 1);
    }

    public void add() {
        this.atomic = this.atomic + 1;
    }
}

