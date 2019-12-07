package com.basic.thread.threadlocal;

public class ThreadLocalThead extends Thread {

    private ThreadLocalObject object;

    public ThreadLocalThead(String name, ThreadLocalObject object) {
        super(name);
        this.object = object;
    }

    @Override
    public void run() {
        object.setValue(this.getName());
        object.setName(this.getName());
        object.getValue();
    }

}
