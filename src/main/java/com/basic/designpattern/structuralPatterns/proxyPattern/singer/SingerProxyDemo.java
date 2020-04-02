package com.basic.designpattern.structuralPatterns.proxyPattern.singer;

public class SingerProxyDemo {

	public static void main(String[] args) {
		Sing zhang = new Agent("love song");
		zhang.sing();
		
		System.out.println("=================================");
		zhang.sing();
	}
	
}
