package com.basic.designpattern.behavioralPatterns.templatePattern;

/**
 * 1、有多个子类共有的方法，且逻辑相同。 
 * 2、重要的、复杂的方法，可以考虑作为模板方法。
 * 为防止恶意操作，一般模板方法都加上 final 关键词。
 * @author 170186
 *
 */
public abstract class Game {

	abstract void initalize();
	
	abstract void startPlay();
	
	abstract void endPlay();
	
	// 玩游戏的模板
	public void play() {
		// 初始化
		this.initalize();
		
		// 开始游戏
		this.startPlay();
		
		// 结束游戏
		this.endPlay();
	}
}
