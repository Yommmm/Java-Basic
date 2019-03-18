package com.basic.datastruct.stack;

public interface Stack<E> {

	public void push(E e);
	
	public E pop();
	
	public E peek();
	
	public int getSize();
	
	public boolean isEmpty();
	
}
