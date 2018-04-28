package com.basic;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("123");
		list.add("123");
		list.add("123");
		list.add("123");
		list.add("123");
		list.add("123");
		list.add("123");
		list.add("123");
		String a = list.toString();
		System.out.println(a);
		System.out.println(a.substring(1, a.length() - 1));
		System.out.println(a.substring(1, a.length() - 1).replace(" ", ""));
	}
	
}
