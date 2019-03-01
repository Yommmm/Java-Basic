package com.basic.thread.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ServiceWW {

	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	public void ww() {
		try {
			readWriteLock.writeLock().lock();
			System.out.println(Thread.currentThread().getName() + "开始睡觉！");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}
	
}
