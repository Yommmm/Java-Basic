package com.basic;

public class Testb extends Testc {

	static {
		System.out.println("static Testb");
	}
	
	{
		System.out.println("Testb");
	}
	
	public Testb() {
		System.out.println("I am Testb");
	}
	
	public static void main(String[] args) {
		Testb testb = new Testb();
	}
	
}

class Testc {
	static {
		System.out.println("static Testc");
	}
	
	{
		System.out.println("Testc");
	}
	
	public Testc() {
		System.out.println("I am Testc");
	}
	
}
