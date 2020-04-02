package com.basic.designpattern.structuralPatterns.bridgePattern;

public class Circle extends Shape {

	private int radius;
	
	private int x;
	
	private int y;
	
	public Circle(DrawAPI drawAPI, int radius, int x, int y) {
		super(drawAPI);
		this.radius = radius;
		this.x = x;
		this.y = y;
		
	}

	@Override
	public void draw() {
		drawAPI.drawCircle(radius, x, y);
	}

}
