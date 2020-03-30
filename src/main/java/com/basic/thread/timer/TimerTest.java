package com.basic.thread.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    private static Timer timer = new Timer(/* 是否创建为守护线程 true*/);

    public static class MyTask extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println("Start: " + new Date());
                System.out.println("定时任务来了");
                Thread.sleep(7000);
                System.out.println("End: " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse("2019-03-01 15:48:00");

        MyTask myTask = new MyTask();

        /**
         * 运行一次
         */
//		timer.schedule(myTask, parse);

        /**
         * 运行多次
         * 从指定时间开始，每6秒运行一次
         */
//		timer.schedule(myTask, parse, 6000);

        /**
         * 以当前时间为基准，延时6秒执行一次
         */
//		timer.schedule(myTask, 6000);

        /**
         * 以当前时间为基准，延时6秒执行一次
         * 之后每6秒执行一次
         */
//		timer.schedule(myTask, 6000, 6000);

        /**
         * 如果任务执行没有延时
         * schedule()方法，下一次任务的执行时间参考，从上一次任务的【开始】时间来计算
         * scheduleAtFixedRate()方法，下一次任务的执行时间参考，从上一次任务的【结束】时间来计算
         * 如果延时超过执行时间差，后一次任务立即执行
         */
        timer.scheduleAtFixedRate(myTask, parse, 6000);
    }

}
