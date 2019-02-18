package com.basic.thread.stop;

public class ThreadStop2 implements Runnable {

	@Override
	public void run() {
		int i = 0;
		while(i <= 500000) {
			System.out.println("i = " + i);
			i++;
		}
	}

}
