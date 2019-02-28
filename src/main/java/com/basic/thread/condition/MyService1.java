package com.basic.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService1 {
	
	private ReentrantLock lock = new ReentrantLock();
	
	private Condition conditionA = lock.newCondition();
	
	private Condition conditionB = lock.newCondition();

	public void waitA() {
		try {
			lock.lock();
			System.out.println("waitA start");
			conditionA.await();
			System.out.println("waitA end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void waitB() {
		try {
			lock.lock();
			System.out.println("waitB start");
			conditionB.await();
			System.out.println("waitB end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void signalAll_A() {
		try {
			lock.lock();
			System.out.println("signalA start");
			conditionA.signalAll();
			System.out.println("signalA end");
		} finally {
			lock.unlock();
		}
	}
	
	public void signalAll_B() {
		try {
			lock.lock();
			System.out.println("signalB start");
			conditionB.signalAll();
			System.out.println("signalB end");
		} finally {
			lock.unlock();
		}
	}
	
}
