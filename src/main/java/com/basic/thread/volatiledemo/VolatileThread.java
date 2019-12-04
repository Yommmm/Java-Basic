package com.basic.thread.volatiledemo;

public class VolatileThread extends Thread {

    private Test test;

    private boolean cm;

    public VolatileThread(boolean cm, Test test, String name) {
        this.cm = cm;
        this.test = test;
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(test.hashCode());
                if(cm) {
                    Thread.sleep(30);
                    test.count = test.count + 1;
                    System.out.println(getName() + "修改值的线程：" + test.count);
                } else {
                    Thread.sleep(10);
                    System.out.println(getName() + "读取值的线程：" + test.count);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test test = new Test(0);

        VolatileThread thread = new VolatileThread(true, test, "update");
        VolatileThread thread2 = new VolatileThread(false, test, "read");
        thread.start();
        thread2.start();
    }

}

class Test {
    int count;

    public Test(int count) {
        this.count = count;
    }
}
