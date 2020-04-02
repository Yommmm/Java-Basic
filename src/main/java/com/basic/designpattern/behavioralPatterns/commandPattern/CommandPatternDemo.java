package com.basic.designpattern.behavioralPatterns.commandPattern;

/**
 * 命令模式
 * "行为请求者"与"行为实现者"解耦
 * @author 170186
 *
 */
public class CommandPatternDemo {
	
	public static void main(String[] args) {
		
		Stock stock = new Stock();

	    BuyStock buyStockOrder = new BuyStock(stock);
	    SellStock sellStockOrder = new SellStock(stock);

	    // 输入命令
	    Broker broker = new Broker();
	    broker.takeOrder(buyStockOrder);
	    broker.takeOrder(sellStockOrder);
	    broker.takeOrder(buyStockOrder);

	    // 执行命令
	    broker.placeOrders();
	    
	    // 输入命令
	    broker.takeOrder(buyStockOrder);
	    // 执行命令
	    broker.placeOrders();
	}
    
}
