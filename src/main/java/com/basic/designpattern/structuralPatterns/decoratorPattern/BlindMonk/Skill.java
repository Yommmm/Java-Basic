package com.basic.designpattern.structuralPatterns.decoratorPattern.BlindMonk;

public class Skill implements Hero {
	
	// 持有一个英雄对象接口
	private Hero hero;

	public Skill(Hero hero) {
		this.hero = hero;
	}

	@Override
	public void learnSkill() {
		if (hero != null) {
			hero.learnSkill();
		}
	}
}
