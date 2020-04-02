package com.basic.designpattern.structuralPatterns.proxyPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Test memory model
 * @author 170186
 *
 */
public class Test {

	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.setName("demo");
		List<Daye> arrList = new ArrayList<Daye>();
		Daye tom = new Daye("Tom", 42);
		Daye john = new Daye("John", 45);
		arrList.add(tom);
		arrList.add(john);
		demo.setList(arrList);
		System.out.println(demo);
		
		demo.getList().add(tom);
		demo.getList().get(0).setAge(100);
		System.out.println(demo);
	}
}

class Demo {
	
	private String name;
	private List<Daye> list;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Daye> getList() {
		return list;
	}
	public void setList(List<Daye> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Demo [name=" + name + ", list=" + list.toString() + "]";
	}
	
}

class Daye {
	
	private String name;
	
	private int age;
	
	public Daye(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Daye [name=" + name + ", age=" + age + "]";
	}
	
}
