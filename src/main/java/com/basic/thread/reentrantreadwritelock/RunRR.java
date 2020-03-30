package com.basic.thread.reentrantreadwritelock;

public class RunRR {

    public static void main(String[] args) {
        final ServiceRR serviceRR = new ServiceRR();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                serviceRR.rr();
            }
        };

        for (int i = 0; i <= 10; i++) {
            new Thread(runnable).start();
        }
    }

}
