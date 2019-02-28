package com.basic.thread.condition;

public class ThreadBB extends Thread {
	
	private MyService1 myService1;
	
	public ThreadBB(MyService1 myService1) {
		super();
		this.myService1 = myService1;
	}

	@Override
	public void run() {
		myService1.waitB();
	}

}
