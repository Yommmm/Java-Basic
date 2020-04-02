package com.basic.designpattern.creationalPatterns.singleton;

/**
 * 饿汉式单例，线程安全
 * @author 170186
 *
 */
public class Singleton {

	private Singleton() {};
	
	private static Singleton instance = new Singleton();
	
	public static Singleton getInstance() {
		return instance;
	}
	
	public String hello() {
		return "hello singleton!";
	}
	
}
