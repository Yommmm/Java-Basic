package com.basic.datastruct.stack;

public class LinkedListStackDemo {

	public static void main(String[] args) {
		LinkedListStack<Integer> stack = new LinkedListStack<>();
		stack.push(999);
		stack.push(888);
		stack.push(777);
		stack.push(666);
		System.out.println(stack);
		
		System.out.println(stack.pop());
		
		System.out.println(stack.peek());
		
		System.out.println(stack);
		
		System.out.println(stack.getSize());
	}
	
}
