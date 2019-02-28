package com.basic.thread.condition;

public class ThreadAA extends Thread {
	
	private MyService1 myService1;
	
	public ThreadAA(MyService1 myService1) {
		super();
		this.myService1 = myService1;
	}

	@Override
	public void run() {
		myService1.waitA();
	}

}
