package com.basic.thread.waitnotify;

public class Run {

	/*public static void main(String[] args) {
		try {
			String lock = new String();
			System.out.println("sync 上面");
			synchronized(lock) {
				System.out.println("sync 第一行");
				lock.wait();
				System.out.println("sync 后");
			}
			System.out.println("sync 下面");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/
	
	/*public static void main(String[] args) {
		try {
			String a = new String("a");
			Wait wait = new Wait(a);
			Wait wait1 = new Wait(a);
			wait.start();
			wait1.start();
			Thread.sleep(3000);
			Notify notify = new Notify(a);
			notify.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/

    public static void main(String[] args) {
        try {
            String a = new String("a");
            Wait wait = new Wait(a);
            wait.start();
            Thread.sleep(5000);
            wait.interrupt();
            Notify notify = new Notify(a);
            notify.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
