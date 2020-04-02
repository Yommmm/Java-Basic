package com.basic.designpattern.creationalPatterns.builderPattern.meal;

import com.basic.designpattern.creationalPatterns.builderPattern.burger.ChickenBurger;
import com.basic.designpattern.creationalPatterns.builderPattern.burger.VegBurger;
import com.basic.designpattern.creationalPatterns.builderPattern.coldDrink.Coke;
import com.basic.designpattern.creationalPatterns.builderPattern.coldDrink.Pepsi;

public class MealBuilder {

	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
