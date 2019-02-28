package com.basic.thread.condition;

public class Run {

	public static void main(String[] args) {
		try {
			MyService myService = new MyService();
			ThreadA thread = new ThreadA(myService);
			thread.start();
			Thread.sleep(3000);
			myService.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
