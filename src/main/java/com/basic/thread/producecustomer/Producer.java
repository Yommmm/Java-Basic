package com.basic.thread.producecustomer;

/**
 * 生产者
 * @author 170186
 *
 */
public class Producer {

	private String lock;
	
	public Producer(String lock) {
		super();
		this.lock = lock;
	}
	
	public void setValue() {
		try {
			synchronized(lock) {
				if(!"".equals(ValueObject.value)) {
					System.out.println("生产者 " + Thread.currentThread().getName() + " WAITING！");
					lock.wait();
				}
				System.out.println("生产者 " + Thread.currentThread().getName() + " RUNNABLE！");
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				
				System.out.println("生产了： " + value);
				ValueObject.value = value;
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
