package com.basic.designpattern.behavioralPatterns.templatePattern;

public class Football extends Game {

	@Override
	void initalize() {
		System.out.println("Football game prepare.");
	}

	@Override
	void startPlay() {
		System.out.println("Football game start.");
	}

	@Override
	void endPlay() {
		System.out.println("Football game finish.");
	}

}
