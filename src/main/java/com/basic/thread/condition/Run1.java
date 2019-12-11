package com.basic.thread.condition;

public class Run1 {

	public static void main(String[] args) {
		
		try {
			MyService1 myService1 = new MyService1();
			ThreadAA threadAA = new ThreadAA(myService1);
			threadAA.setName("A");
			threadAA.start();
			
			ThreadBB threadBB = new ThreadBB(myService1);
			threadBB.setName("B");
			threadBB.start();
			Thread.sleep(5000);

			myService1.signalAll_A();
//			myService1.signalAll_B();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
