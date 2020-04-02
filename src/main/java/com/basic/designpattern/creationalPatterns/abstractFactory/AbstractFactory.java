package com.basic.designpattern.creationalPatterns.abstractFactory;

import com.basic.designpattern.creationalPatterns.abstractFactory.color.Color;
import com.basic.designpattern.creationalPatterns.abstractFactory.shape.Shape;

public abstract class AbstractFactory {

	public abstract Shape getShape(String shape);
	public abstract Color getColor(String color);
	
}
