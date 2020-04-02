package com.basic.designpattern.structuralPatterns.bridgePattern;

public abstract class Shape {

	DrawAPI drawAPI;
	
	public Shape(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}
	
	public abstract void draw();
	
}
