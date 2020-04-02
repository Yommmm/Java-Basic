package com.basic.designpattern.structuralPatterns.decoratorPattern.BlindMonk;

public class Skill_R extends Skill {

	private String skillName;

	public Skill_R(Hero hero, String skillName) {
		super(hero);
		this.skillName = skillName;
	}

	@Override
	public void learnSkill() {
		System.out.println("学习了技能R:" + skillName);
		super.learnSkill();
	}
}
