package com.basic.designpattern.structuralPatterns.decoratorPattern.BlindMonk;

public class Skill_W extends Skill {

	private String skillName;

	public Skill_W(Hero hero, String skillName) {
		super(hero);
		this.skillName = skillName;
	}

	@Override
	public void learnSkill() {
		System.out.println("学习了技能W:" + skillName);
		super.learnSkill();
	}
}
