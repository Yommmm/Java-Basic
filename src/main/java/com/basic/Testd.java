package com.basic;

public class Testd {

	public static void main(String[] args) {
		System.out.println(re("abc"));
	}
	
	private static String re(String str) {
		if(null == str || str.length() <= 1) {
			return str;
		}
		return re(str.substring(1)) + str.charAt(0);
	}
	
}