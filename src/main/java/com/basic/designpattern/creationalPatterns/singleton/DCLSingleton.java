package com.basic.designpattern.creationalPatterns.singleton;

/**
 * 双检锁单例，线程安全
 * @author 170186
 *
 */
public class DCLSingleton {

	private DCLSingleton() {};
	
	private static volatile DCLSingleton instance;
	
	public static DCLSingleton getInstance() {
		if(null == instance) {
			synchronized(DCLSingleton.class) {
				if(null == instance) {
					instance = new DCLSingleton();
				}
			}
		}
		return instance;
	}
	
	public String hello() {
		return "hello singleton!";
	}
	
}
