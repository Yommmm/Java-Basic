package com.basic.designpattern.behavioralPatterns.observerPattern;

/**
 * 观察者模式
 * @author 170186
 *
 */
public class ObserverPatternDemo {

	public static void main(String[] args) {
		Subject subject = new Subject();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		// 第一次状态改变
		subject.setState(15);
		
		System.out.println("Second state change: 10");
		// 第二次状态改变
		subject.setState(10);
	}
	
}
