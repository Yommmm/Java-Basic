package com.basic.datastruct.queue;

public class LinkedListQueueDemo {

	public static void main(String[] args) {
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
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
