package com.basic.thread.fairandunfair;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private ReentrantLock lock;

    public MyService(Boolean isFair) {
        this.lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("Lock " + Thread.currentThread().getName() + "获得锁定");
        } finally {
            lock.unlock();
        }

    }

}
