package com.basic.designpattern.creationalPatterns.singleton;

/**
 * 懒汉式单例，线程安全
 * @author 170186
 *
 */
public class LazySingletonS {

	private LazySingletonS() {};
	
	private static LazySingletonS instance;
	
	public static synchronized LazySingletonS getInstance() {
		if (null == instance) {
			return new LazySingletonS();
		}
		return instance;
	}
	
	public String hello() {
		return "hello lazy singleton thread security!";
	}
	
}
