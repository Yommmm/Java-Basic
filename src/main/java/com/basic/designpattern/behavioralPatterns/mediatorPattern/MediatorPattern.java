package com.basic.designpattern.behavioralPatterns.mediatorPattern;

public class MediatorPattern {

	public static void main(String[] args) {
		User robert = new User("Robert");
		User john = new User("John");

		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Robert!");
	}
}
