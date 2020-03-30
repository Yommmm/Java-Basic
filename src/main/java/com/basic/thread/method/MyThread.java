package com.basic.thread.method;

public class MyThread extends Thread {

    /**
     * 普通线程Demo
     *
     * @param args
     */
	/*@Override
	public void run() {
		super.run();
		System.out.println("MyThread");
	}*/

    private int count = 5;

    /**
     * 线程私有实例变量Demo
     * @param args
     */
	/*public MyThread(String name) {
		// TODO Auto-generated constructor stub
		super();
		this.setName(name);
	}
	
	@Override
	public void run() {
		super.run();
		while(count > 0) {
			count --;
			System.out.println("由 " + currentThread().getName() + " 计算，count=" + count);
		}
	}*/

    /**
     * 线程共享实例变量，但不安全的Demo
     */
	/*@Override
	public void run() {
		super.run();
		count --;
		System.out.println("由 " + currentThread().getName() + " 计算，count=" + count);
	}*/

    /**
     * 线程共享实例变量，且安全的Demo
     */
    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由 " + currentThread().getName() + " 计算，count=" + count);
    }

}
