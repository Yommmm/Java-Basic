package com.basic.thread.producecustomer;

/**
 * 消费者
 * @author 170186
 *
 */
public class Customer {

	private String lock;

	public Customer(String lock) {
		super();
		this.lock = lock;
	}
	
	public void getValue() {
		try {
			synchronized(lock) {
				if("".equals(ValueObject.value)) {
					System.out.println("消费者 " + Thread.currentThread().getName() + " WAITING！");
					lock.wait();
				}
				System.out.println("消费者 " + Thread.currentThread().getName() + " WAITING！");
				System.out.println("消费了： " + ValueObject.value);
				ValueObject.value = "";
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
