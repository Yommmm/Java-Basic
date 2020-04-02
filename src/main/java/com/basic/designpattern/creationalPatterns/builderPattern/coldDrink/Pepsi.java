package com.basic.designpattern.creationalPatterns.builderPattern.coldDrink;

public class Pepsi extends ColdDrink {

	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 6.66f;
	}

}
