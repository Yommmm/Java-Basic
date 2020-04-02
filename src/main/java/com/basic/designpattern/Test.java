package com.basic.designpattern;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.first();
	}
	
	public void first() {
		Value v = new Value();
		v.i = 25;
		System.out.println("first"+v);
		second(v);
		System.out.println("first"+v);
	}
	
	public void second(Value v) {
		Value val = new Value();
		val.i = 20;
		System.out.println("second"+val);
		v = val;
		System.out.println("second"+v);
	}
}

class Value {
	public int i;

	@Override
	public String toString() {
		return "Value [i=" + i + "]";
	}
	
}