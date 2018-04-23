package com.basic;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		System.out.println("start");
		
		Test test = new Test();
		test.tset();
		
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
	
	public void tset() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "2");
		map.put("1", "3");
		System.out.println(map.toString());
	}
	
}
