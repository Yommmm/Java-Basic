package com.basic.thread.stop;

public class ThreadStop extends Thread {

    @Override
    public void run() {
        super.run();
        int i = 0;
        while (i <= 500000) {
            System.out.println("i = " + i);
            i++;
        }
    }

}
