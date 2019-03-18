package com.basic.datastruct.queue;

public class LoopQueueDemo {

	public static void main(String[] args) {
		LoopQueue<Character> queue = new LoopQueue<>();
		queue.enQueue('a');
		queue.enQueue('b');
		queue.enQueue('c');
		queue.enQueue('d');
		queue.enQueue('e');
		queue.enQueue('f');
		queue.enQueue('g');
		queue.enQueue('h');
		queue.enQueue('i');
		queue.enQueue('j');
		queue.enQueue('k');
		System.out.println(queue);
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		
		System.out.println(queue);
	}
	
}
