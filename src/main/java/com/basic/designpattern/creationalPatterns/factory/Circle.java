package com.basic.designpattern.creationalPatterns.factory;

public class Circle implements Shape {
	
	private String a;

	@Override
	public void draw() {
		System.out.println("Circle");
		System.out.println(a);
	}

	public void circleWithParams(String a) {
		this.a = a;
	}

}
