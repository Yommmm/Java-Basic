package com.basic.designpattern.creationalPatterns.prototypePattern;

public class Square extends Shape {

	public Square() {
		this.type = "Square";
	}
	
	@Override
	void draw() {
		System.out.println("Square");
	}

}
