package com.basic.designpattern.behavioralPatterns.templatePattern;

public class Cricket extends Game {

	@Override
	void initalize() {
		System.out.println("Cricket game prepare.");
	}

	@Override
	void startPlay() {
		System.out.println("Cricket game start.");		
	}

	@Override
	void endPlay() {
		System.out.println("Cricket game finish.");		
	}

}
