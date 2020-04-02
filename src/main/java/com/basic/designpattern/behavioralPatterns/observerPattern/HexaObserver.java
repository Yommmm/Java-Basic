package com.basic.designpattern.behavioralPatterns.observerPattern;

public class HexaObserver extends Observer {

	/**
	 * 构造方法中订阅Subject
	 */
	public HexaObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	/**
	 * 观察者观察到变化并输出
	 */
	@Override
	public void update() {
		System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
	}

}
