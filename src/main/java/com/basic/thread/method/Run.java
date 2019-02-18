package com.basic.thread.method;

public class Run {

	/**
	 * 普通线程Demo
	 * @param args
	 */
	/*public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		System.out.println("运行结束！");
	}*/
	
	/**
	 * 线程私有实例变量Demo
	 * @param args
	 */
	/*public static void main(String[] args) {
		MyThread a = new MyThread("A");
		MyThread b = new MyThread("B");
		MyThread c = new MyThread("C");
		a.start();
		b.start();
		c.start();
		System.out.println("运行结束！");
	}*/
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread a = new Thread(myThread, "A");
		Thread b = new Thread(myThread, "B");
		Thread c = new Thread(myThread, "C");
		Thread d = new Thread(myThread, "D");
		System.out.println(a.isAlive());
		System.out.println(a.currentThread().getName() + a.getId());
		a.start();
		System.out.println(a.isAlive());
		System.out.println(a.currentThread().getName() + a.getId());
		b.start();
		System.out.println(a.isAlive());
		c.start();
		System.out.println(a.isAlive());
		d.start();
		System.out.println(a.isAlive());
	}
	
}
