package com.basic.thread.pools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class ThreadPool0509 {

    /*public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, null);

        int i = 0;
        while (i < 10000) {
            Thread thread = new Thread("Thread" + i) {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "start!");
                }
            };

            threadPoolExecutor.execute(thread);
            i++;
        }

    }*/

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(5,
                10,
                60L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                new CustomThreadFactory());
        for (int i = 0; i < 15; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("由线程：" + Thread.currentThread().getName() + "执行任务完成");
            });
        }
    }

}
