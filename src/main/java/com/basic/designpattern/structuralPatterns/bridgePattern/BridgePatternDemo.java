package com.basic.designpattern.structuralPatterns.bridgePattern;

/**
 * 桥接模式
 * @author 170186
 *
 */
public class BridgePatternDemo {

	public static void main(String[] args) {
		Shape redCircle = new Circle(new RedCircle(), 10, 100, 100);
		Shape greenCircle = new Circle(new GreenCircle(), 10, 100, 100);

		redCircle.draw();
		greenCircle.draw();
	}

}
