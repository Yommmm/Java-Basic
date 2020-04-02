package com.basic.designpattern.creationalPatterns.abstractFactory.shape;

import com.basic.designpattern.creationalPatterns.abstractFactory.AbstractFactory;
import com.basic.designpattern.creationalPatterns.abstractFactory.color.Color;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		return null;
	}

	@Override
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
