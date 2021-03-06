package com.basic.thread.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ServiceRR {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void rr() {
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "开始加锁睡觉！");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
