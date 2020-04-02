package com.basic.designpattern.structuralPatterns.proxyPattern;

/**
 * 代理模式
 * @author 170186
 *
 */
public class ProxyPatternDemo {

	public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");

		// 代理开始第一次使用对象时，先进行一些操作，此处为加载
		// 歌手签约经纪人，签约等等就是代理前的操作，代理后就不需要再进行哪些操作，只要让歌手唱歌就行
		image.display();
		System.out.println("");
		// 第二次使用时，不需要再次加载()
		image.display();
	}

}
