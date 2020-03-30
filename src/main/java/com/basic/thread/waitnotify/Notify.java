package com.basic.thread.waitnotify;

public class Notify extends Thread {

    private Object lock;

    public Notify(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        synchronized (lock) {
            System.out.println(lock.toString() + Thread.currentThread().getId() + "开始通知 " + System.currentTimeMillis());
//			lock.notify();
//			lock.notify();
            lock.notifyAll();
            System.out.println(lock.toString() + Thread.currentThread().getId() + "结束通知 " + System.currentTimeMillis());
        }
    }

}
