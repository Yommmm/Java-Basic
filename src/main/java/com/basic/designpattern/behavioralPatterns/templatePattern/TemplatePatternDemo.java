package com.basic.designpattern.behavioralPatterns.templatePattern;

/**
 * 模板模式
 * 一个抽象类公开定义了执行它的方法的方式/模板。
 * 它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。
 * @author 170186
 *
 */
public class TemplatePatternDemo {

	public static void main(String[] args) {
		Game game = new Cricket();
		game.play();
		game = new Football();
		game.play();
	}
}
