package com.basic.concurconcurrent;

public class ThreadTestDemo {

	public static void main(String[] args) {
		try {
			ZhangFei zhangfei = new ZhangFei();
			zhangfei.notify();
			
			Thread.sleep(3000);
			for(int i = 0; i < 10; i++) {
				System.out.println("我是你二哥，给我停下");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
