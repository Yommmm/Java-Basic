package com.basic;

public class Testa {

	public static void main(String[] args) {
		String a = "programming";
		String b = new String("programming");
		String c = "program" + "ming";
		
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(a.intern() == b.intern());
	}
	
}
