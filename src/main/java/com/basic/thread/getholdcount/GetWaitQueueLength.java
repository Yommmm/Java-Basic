package com.basic.thread.getholdcount;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class GetWaitQueueLength {

    public ReentrantLock lock = new ReentrantLock();

    public Condition condition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            lock.lock();
            System.out.println("有" + lock.getWaitQueueLength(condition) + "个线程在等待 condition 这个对象资源");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final GetWaitQueueLength getWaitQueueLength = new GetWaitQueueLength();

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                getWaitQueueLength.waitMethod();
            }
        };

        for (int i = 1; i <= 10; i++) {
            new Thread(runnable).start();
        }

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            getWaitQueueLength.notifyMethod();
        }
    }

}
