package com.basic.thread.reentrantreadwritelock;

public class RunRW {

	public static void main(String[] args) {
		final ServiceRW serviceRW = new ServiceRW();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				serviceRW.rr();
			}
		};
		
		Runnable runnable1 = new Runnable() {
			
			@Override
			public void run() {
				serviceRW.ww();
			}
		};
		
		for(int i = 0; i <= 5; i++) {
			System.out.println(i & 1);
			if((i & 1) == 1) {
				new Thread(runnable).start();
			} else {
				new Thread(runnable1).start();
			}
		}
	}
	
}
