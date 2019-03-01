package com.basic.thread.reentrantreadwritelock;

public class RunWW {

	public static void main(String[] args) {
		final ServiceWW serviceWW = new ServiceWW();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				serviceWW.ww();
			}
		};
		
		for(int i = 0; i <= 10; i++) {
			new Thread(runnable).start();
		}
	}
	
}
