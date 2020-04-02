package com.basic.designpattern.structuralPatterns.decoratorPattern.BlindMonk;

public abstract class HeroDecorator implements Hero {

	protected Hero heroDecorator;
	
	public HeroDecorator(Hero heroDecorator) {
		this.heroDecorator = heroDecorator;
	}

	@Override
	public void learnSkill() {
		this.heroDecorator.learnSkill();
	}
	
}
