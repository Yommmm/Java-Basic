package com.basic.designpattern.behavioralPatterns.commandPattern;

public class Stock {

	private String name = "Umbrella";

	private int quantity = 100;

	public void buy() {
		System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
	}

	public void sell() {
		System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
	}

}
