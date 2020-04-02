package com.basic.designpattern.behavioralPatterns.commandPattern;

public class SellStock implements Order {

	private Stock stock;
	
	public SellStock(Stock stock) {
		this.stock = stock;
	}
	
	@Override
	public void execute() {
		this.stock.sell();
	}

}
