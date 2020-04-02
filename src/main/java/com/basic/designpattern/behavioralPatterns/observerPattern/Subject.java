package com.basic.designpattern.behavioralPatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List<Observer> observers = new ArrayList<Observer>();

	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		this.notifyAllObservers();
	}

	// 观察者订阅方法
	public void attach(Observer observer) {
		this.observers.add(observer);
	}

	// 通知观察者状态被改变
	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
