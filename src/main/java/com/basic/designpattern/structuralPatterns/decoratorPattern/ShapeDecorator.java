package com.basic.designpattern.structuralPatterns.decoratorPattern;

public abstract class ShapeDecorator implements Shape {

	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	@Override
	public void draw() {
		this.decoratedShape.draw();
	}

}
