package com.basic;

public class Test {

	public static void main(String[] args) {
		System.out.println("start");
		
		Test test = new Test();
		System.out.println(test.test("sync invoking"));
		
		System.out.println("end");
	}
	
	public String test(String string) {
		
		new Thread() {
			public void run() {
				int i = 0;
				while(i < 10) {
					System.out.println("2222222222222222222222222222");
					i++;
				}
			}
		}.start();
		
		return string;
	}
	
}
