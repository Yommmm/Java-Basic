package com.basic.thread.threadlocal;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocalObject object = new ThreadLocalObject();
        for(int i = 0; i < 10; i++) {
            ThreadLocalThead thread = new ThreadLocalThead("Thread" + String.valueOf(i), object);
            thread.start();
        }
    }

}
