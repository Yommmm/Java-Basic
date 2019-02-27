package com.basic.thread.threadlocal;

public class Run2 {
	
	private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

	public static void main(String[] args) {
		inheritableThreadLocal.set("hahhhhhhhhh");
		System.out.println("父线程" + inheritableThreadLocal.get());
		Thread thread = new Thread() {

			@Override
			public void run() {
				System.out.println("子线程" + inheritableThreadLocal.get());
			}
			
		};
		
		thread.start();
	}
	
}
