package com.basic.thread.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ServiceRW {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void rr() {
        try {
            readWriteLock.readLock().lock();
            System.out.println("读 " + Thread.currentThread().getName() + "开始睡觉！");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void ww() {
        try {
            readWriteLock.writeLock().lock();
            System.out.println("写 " + Thread.currentThread().getName() + "开始睡觉！");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

}
