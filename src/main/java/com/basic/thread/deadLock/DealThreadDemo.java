package com.basic.thread.deadLock;

public class DealThreadDemo {

	public static void main(String[] args) {
		try {
			DealThread dealThread = new DealThread();
			dealThread.setFlag("a");
			Thread thread1 = new Thread(dealThread);
			thread1.start();
			Thread.sleep(2000);
			dealThread.setFlag("b");
			Thread thread2 = new Thread(dealThread);
			thread2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
