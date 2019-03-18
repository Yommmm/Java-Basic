package com.basic.datastruct.queue;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<>();
		queue.enQueue(111);
		queue.enQueue(222);
		queue.enQueue(333);
		queue.enQueue(444);
		
		System.out.println(queue);
		
		System.out.println(queue.getFront());
		queue.deQueue();
		System.out.println(queue);
		
	}
	
}
