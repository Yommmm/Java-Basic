package com.basic.designpattern.behavioralPatterns.commandPattern;

import java.util.ArrayList;
import java.util.List;

public class Broker {

	private List<Order> orders = new ArrayList<Order>();
	
	/**
	 * 输入命令
	 * @param order
	 */
	public void takeOrder(Order order) {
		this.orders.add(order);
	}
	
	/**
	 * 执行命令，并清除已执行命令
	 */
	public void placeOrders() {
		for(Order order : orders) {
			order.execute();
		}
		this.orders.clear();
	}
	
}
