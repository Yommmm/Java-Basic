package com.basic.designpattern.creationalPatterns.abstractFactory.color;

import com.basic.designpattern.creationalPatterns.abstractFactory.AbstractFactory;
import com.basic.designpattern.creationalPatterns.abstractFactory.shape.Shape;

public class ColorFactory extends AbstractFactory {
	
	@Override
	public Shape getShape(String shape) {
		return null;
	}
	
	@Override
	public Color getColor(String color) {
		if(null == color || "".equals(color)) {
			return null;
		}
		if(color.equalsIgnoreCase("red")) {
			return new Red();
		}
		if(color.equalsIgnoreCase("green")) {
			return new Green();
		}
		if(color.equalsIgnoreCase("blue")) {
			return new Blue();
		}
		return null;
	}
	
}
