package com.basic.thread.threadlocal;

public class Run3 {

    private static InheritableThreadLocalExt inheritableThreadLocalExt = new InheritableThreadLocalExt();

    public static void main(String[] args) {
        inheritableThreadLocalExt.set("hahhhhhhhhh");
        System.out.println("父线程" + inheritableThreadLocalExt.get());
        Thread thread = new Thread() {

            @Override
            public void run() {
                System.out.println(inheritableThreadLocalExt.get());
            }

        };

        thread.start();
    }

}
