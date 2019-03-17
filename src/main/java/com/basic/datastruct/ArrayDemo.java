package com.basic.datastruct;

public class ArrayDemo {

	public static void main(String[] args) {
		Array arr = new Array(20);
		
		for(int i = 0; i < 10; i++) {
			arr.addLast(i);
		}
		System.out.println(arr.toString());
		
		arr.add(1, 100);
		System.out.println(arr.toString());
		
		System.out.println(arr.get(1));
		
		arr.set(1, 99);
		
		System.out.println(arr.toString());
	}
	
}
