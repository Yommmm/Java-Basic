package com.basic.datastruct.stack;

import com.basic.datastruct.array.Array;

public class ArrayStack<E> implements Stack<E>{

	private Array<E> arr;
	
	public ArrayStack(int capacity) {
		arr = new Array<E>(capacity);
	}
	
	public ArrayStack() {
		this(10);
	}

	public void push(E e) {
		arr.addLast(e);
	}
	
	@Override
	public E pop() {
		return arr.removeLast();
	}
	
	@Override
	public E peek() {
		return arr.getFirst();
	}
	
	@Override
	public int getSize() {
		return arr.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		return 0 == arr.getSize();
	}
	
	public int getCapacity() {
		return arr.getCapacity();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Stack: [");
		for(int i = 0; i < arr.getSize(); i++) {
			res.append(arr.get(i));
			if(i != arr.getSize() - 1) {
				res.append(", ");
			}
		}
		res.append("] pop");
		
		return res.toString();
	}
	
}
