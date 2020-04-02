package com.basic.designpattern.creationalPatterns.prototypePattern;

public class Circle extends Shape {

	public Circle() {
		this.type = "Circle";
	}
	
	@Override
	void draw() {
		System.out.println("Circle");
	}

}
