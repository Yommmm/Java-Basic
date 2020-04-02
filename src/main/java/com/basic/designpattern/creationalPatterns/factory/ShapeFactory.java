package com.basic.designpattern.creationalPatterns.factory;

public class ShapeFactory {

	public Shape getShape(String shape) {
		if(null == shape || "".equals(shape)) {
			return null;
		}
		
		if(shape.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		}
		
		if(shape.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		}
		
		if(shape.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		
		return null;
		
	}
	
}
