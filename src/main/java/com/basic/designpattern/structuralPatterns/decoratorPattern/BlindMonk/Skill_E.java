package com.basic.designpattern.structuralPatterns.decoratorPattern.BlindMonk;

public class Skill_E extends Skill {

	private String skillName;

	public Skill_E(Hero hero, String skillName) {
		super(hero);
		this.skillName = skillName;
	}

	@Override
	public void learnSkill() {
		System.out.println("学习了技能E:" + skillName);
		super.learnSkill();
	}
}
