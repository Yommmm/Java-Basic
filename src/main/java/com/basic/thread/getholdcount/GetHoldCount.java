package com.basic.thread.getholdcount;

import java.util.concurrent.locks.ReentrantLock;

public class GetHoldCount {

    private ReentrantLock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println("methodA say: getHoldCount() value is " + lock.getHoldCount() + " now");
            this.methodB();
        } finally {
            lock.unlock();
            System.out.println("unlock A " + lock.getHoldCount() + " now");
        }
    }

    public void methodB() {
        try {
            lock.lock();
            System.out.println("methodB say: getHoldCount() value is " + lock.getHoldCount() + " now");
        } finally {
            lock.unlock();
            System.out.println("unlock B " + lock.getHoldCount() + " now");
        }
    }

    public static void main(String[] args) {
        GetHoldCount getHoldCount = new GetHoldCount();
        getHoldCount.methodA();
    }

}
