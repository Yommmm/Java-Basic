package com.basic.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

	private ReentrantLock lock = new ReentrantLock();
	
	private Condition condition = lock.newCondition();
	
	public void waitMethod() {
		try {
			lock.lock();
			System.out.println("wait start");
			condition.await();
			System.out.println("wait end");
			lock.unlock();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void signal() {
		try {
			lock.lock();
			System.out.println("signal start");
			condition.signal();
			System.out.println("signal end");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}
