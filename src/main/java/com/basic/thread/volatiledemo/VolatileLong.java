package com.basic.thread.volatiledemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Volatile不能保证原子性的测试
 *
 * @author 85374
 * @date
 */
public class VolatileLong {

    public static void main(String[] args) throws InterruptedException {
        LongData atomicData = new LongData();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicData.addValue();
                }
            }, "AddThread" + i).start();
        }

//        TimeUnit.SECONDS.sleep(10);

        System.out.println(atomicData.value);
        System.out.println(atomicData.value);
        System.out.println(atomicData.value);
        System.out.println(atomicData.value);
        System.out.println(atomicData.value);
        System.out.println(atomicData.value);

        TimeUnit.SECONDS.sleep(3);
        System.out.println(atomicData.value);
        TimeUnit.SECONDS.sleep(3);
        System.out.println(atomicData.value);
        TimeUnit.SECONDS.sleep(3);
        System.out.println(atomicData.value);
        TimeUnit.SECONDS.sleep(3);
        System.out.println(atomicData.value);
        TimeUnit.SECONDS.sleep(3);
        System.out.println(atomicData.value);
        TimeUnit.SECONDS.sleep(3);
        System.out.println(atomicData.value);

    }

}

class LongData {

    volatile long value;

    public void addValue() {
        value++;
//        System.out.println(value);
    }

}

