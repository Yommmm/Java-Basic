package com.basic.thread.producecustomer;

public class ThreadP extends Thread {

	private Producer producer;

	public ThreadP(Producer producer) {
		super();
		this.producer = producer;
	}

	@Override
	public void run() {
		super.run();
		while(true) {
			this.producer.setValue();
		}
	}
	
}
