package com.basic.thread.producecustomer;

public class ThreadC extends Thread {

	private Customer customer;

	public ThreadC(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public void run() {
		super.run();
		while(true) {
			this.customer.getValue();
		}
	}
	
}
