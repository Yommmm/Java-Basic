package com.basic.designpattern.creationalPatterns.builderPattern.burger;

import com.basic.designpattern.creationalPatterns.builderPattern.Item;
import com.basic.designpattern.creationalPatterns.builderPattern.Packing;
import com.basic.designpattern.creationalPatterns.builderPattern.Wrapper;

public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
	
}
