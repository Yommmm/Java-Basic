package com.basic.thread.waitnotify;

public class Wait extends Thread {

    private Object lock;

    public Wait(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            super.run();
            synchronized (lock) {
                System.out.println(lock.toString() + Thread.currentThread().getId() + "开始等待 " + System.currentTimeMillis());
                lock.wait();
                System.out.println(lock.toString() + Thread.currentThread().getId() + "结束等待 " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
