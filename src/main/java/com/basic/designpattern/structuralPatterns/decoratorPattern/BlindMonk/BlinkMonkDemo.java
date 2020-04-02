package com.basic.designpattern.structuralPatterns.decoratorPattern.BlindMonk;

public class BlinkMonkDemo {

	public static void main(String[] args) {
		// 选择英雄
		Hero hero = new BlindMonk("李青");

		Hero skill = new Skill(hero);
		Skill r = new Skill_R(skill, "猛龙摆尾");
		Skill e = new Skill_E(r, "天雷破/摧筋断骨");
		Skill w = new Skill_W(e, "金钟罩/铁布衫");
		Skill q = new Skill_Q(w, "天音波/回音击");
		// 学习技能
		q.learnSkill();
	}
}
