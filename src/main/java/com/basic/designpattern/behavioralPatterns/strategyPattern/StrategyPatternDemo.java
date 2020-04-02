package com.basic.designpattern.behavioralPatterns.strategyPattern;

/**
 * 策略模式
 * @author 170186
 *
 */
public class StrategyPatternDemo {

	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationSub());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationMul());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}
	
}
