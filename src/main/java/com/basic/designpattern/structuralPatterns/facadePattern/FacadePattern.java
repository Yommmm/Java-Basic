package com.basic.designpattern.structuralPatterns.facadePattern;

/**
 * 外观模式Demo
 * @author 170186
 *
 */
public class FacadePattern {

	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}
