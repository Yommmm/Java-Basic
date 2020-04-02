package com.basic.designpattern.structuralPatterns.decoratorPattern;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	/**
	 * this parameter is unused
	 * @param decoratedShape
	 */
	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color: Red");
	}
}
