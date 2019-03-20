package com.basic.datastruct.queue;

import java.util.Random;

public class TestQueue {

	public static void main(String[] args) {
		int testCount = 100000;
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
		LoopQueue<Integer> loopQueue = new LoopQueue<>();
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
		System.out.println("ArrayQueue: " + testQueue(arrayQueue, testCount));
		System.out.println("LoopQueue: " + testQueue(loopQueue, testCount));
		System.out.println("LinkedListQueue: " + testQueue(linkedListQueue, testCount));
	}
	
	public static double testQueue(Queue<Integer> queue, Integer testCount) {
		long startTime = System.nanoTime();
		
		Random random = new Random();
		for(int i = 0; i < testCount; i++)
			queue.enQueue(random.nextInt(Integer.MAX_VALUE));
		
		for(int i = 0; i < testCount; i++)
			queue.deQueue();
		
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1000000000.0;
	}
	
}
