package com.basic.designpattern.structuralPatterns.decoratorPattern.BlindMonk;

public class BlindMonk implements Hero {

	private String name;
	
	public BlindMonk(String name) {
		this.name = name;
	}

	@Override
	public void learnSkill() {
		System.out.println(name + "");
	}

}
