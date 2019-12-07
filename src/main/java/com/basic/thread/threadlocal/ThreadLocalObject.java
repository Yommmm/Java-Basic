package com.basic.thread.threadlocal;

public class ThreadLocalObject {

    private static ThreadLocal<String> tl = new ThreadLocal<>();

    private String name;

    public void setValue(String name) {
        tl.set(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getValue() {
        if("Thread8".equals(name)) {
            System.out.println();
        }
        System.out.println(name + "'s ThreadLocal is: " + tl.get());
    }

}
