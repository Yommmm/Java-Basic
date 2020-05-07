package com.basic.designpattern.creationalPatterns.abstractFactory;

/**
 * 抽象工厂
 * @author 170186
 *
 */
public class AbstractFactoryDemo {

	public static void main(String[] args) {
		AbstractFactory colorFactory = FactoryProducer.getFactory("color");
		colorFactory.getColor("blue").draw();
	}
}
