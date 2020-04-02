package com.basic.designpattern.creationalPatterns.builderPattern.coldDrink;

import com.basic.designpattern.creationalPatterns.builderPattern.Bottle;
import com.basic.designpattern.creationalPatterns.builderPattern.Item;
import com.basic.designpattern.creationalPatterns.builderPattern.Packing;

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();

}
