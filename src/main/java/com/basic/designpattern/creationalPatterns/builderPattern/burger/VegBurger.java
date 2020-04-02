package com.basic.designpattern.creationalPatterns.builderPattern.burger;

public class VegBurger extends Burger {

	@Override
	public String name() {
		return "Veg Burger";
	}

	@Override
	public float price() {
		return 18.8f;
	}

}
