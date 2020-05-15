package com.basic.thread.pools;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class ThreadPool0509 {

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1,
                3,
                60L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                new CustomThreadFactory());



        System.out.println(executorService.getQueue().getClass());

       /*for (int i = 0; i < 6; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("由线程：" + Thread.currentThread().getName() + "执行任务完成");
            });
        }*/

    }

}
