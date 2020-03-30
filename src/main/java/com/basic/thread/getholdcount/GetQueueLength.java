package com.basic.thread.getholdcount;

import java.util.concurrent.locks.ReentrantLock;

public class GetQueueLength {

    public ReentrantLock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "我锁了这个资源对象，并且睡会儿，你们先等等");
            // sleep()不释放对象锁，
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final GetQueueLength getQueueLength = new GetQueueLength();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                getQueueLength.methodA();
            }
        };

        for (int i = 1; i <= 10; i++) {
            new Thread(runnable).start();
        }

        // 这里睡会儿是为了保证10个线程都跑起来了，并且阻塞了9个
        Thread.sleep(2000);
        System.out.println("最后呢？" + getQueueLength.lock.getQueueLength());
    }

}
