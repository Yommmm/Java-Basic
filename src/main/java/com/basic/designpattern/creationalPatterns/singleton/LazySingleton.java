package com.basic.designpattern.creationalPatterns.singleton;

/**
 * 懒汉式单例，非线程安全
 * @author 170186
 *
 */
public class LazySingleton {

	private LazySingleton() {};
	
	private static LazySingleton instance;
	
	public static LazySingleton getInstance() {
		if (null == instance) {
			return new LazySingleton();
		}
		return instance;
	}
	
	public String hello() {
		return "hello lazy singleton!";
	}
	
}
