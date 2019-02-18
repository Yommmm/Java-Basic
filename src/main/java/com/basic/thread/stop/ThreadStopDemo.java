package com.basic.thread.stop;

public class ThreadStopDemo {

	public static void main(String[] args) {
		try {
			ThreadStop threadStop = new ThreadStop();
			threadStop.start();
			Thread.sleep(3000);
			threadStop.interrupt();
			System.out.println(threadStop.isInterrupted());
			System.out.println(Thread.interrupted());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
