package com.basic.thread.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("99999");
            }
        };

        /**
         * 创建一个固定长度的线程池，每当提交一个任务就创建一个线程，直到达到线程池的最大数量
         * 此时线程规模不再变化，当线程发生未知预期错误而结束时，线程池会补充一个新的线程
         */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.submit(thread);

        /**
         * 创建一个可缓存的线程池，如果线程池的规模超过了处理需求，将自动回收空闲线程
         * 当处理需求增加时，可自动添加新的线程，线程池的规模不存在任何限制
         */
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.submit(thread);

        /**
         * 单线程的Executor，创建单个工作线程来执行任务，如果这个线程异常结束，会创建一个新的线程来替代它
         * 特点：能确保依照任务在队列中的顺序来执行
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.submit(thread);

        /**
         * 创建一个固定长度的线程池，而且以延迟或定时的方式来执行任务，类似于Timer
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.submit(thread);

        /**
         *
         */
        ExecutorService workStealingPool = Executors.newWorkStealingPool();
        workStealingPool.submit(thread);

//        ThreadPoolExecutor();
//        new ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,TimeUnit unit, BlockingQueue workQueue, ThreadFactory threadFactory,RejectedExecutionHandler handler);

    }
}
