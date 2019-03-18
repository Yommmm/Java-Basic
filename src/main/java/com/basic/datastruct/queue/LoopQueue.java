package com.basic.datastruct.queue;

public class LoopQueue<E> implements Queue<E> {

	private E[] data;
	
	private int front, tail;
	
	private int size;
	
	@SuppressWarnings("unchecked")
	public LoopQueue(int capacity) {
		data = (E[]) new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}
	
	public LoopQueue() {
		this(10);
	}

	@Override
	public void enQueue(E e) {
		if((tail + 1) % data.length == front)
			resize(getCapacity() << 1);
		
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newCap) {
		E[] newData = (E[]) new Object[newCap + 1];
		for(int i = 0; i < size; i++) {
			newData[i] = data[(i + front) % data.length];
		}
		
		data = newData;
		front = 0;
		tail = size;
	}

	@Override
	public E deQueue() {
		if(isEmpty())
			throw new IllegalArgumentException("Cannot dequeue from an empty queue!");
		
		E ret = data[front];
		front = (front + 1) % data.length;
		size--;
		
		if(size == getCapacity() >> 2 && getCapacity() >> 1 != 0)
			resize(getCapacity() >> 1);
		return ret;
	}

	@Override
	public E getFront() {
		return data[front];
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == tail;
	}
	
	public int getCapacity() {
		return data.length - 1;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("LoopQueue size is %d, capacity is %d\n", size, getCapacity()));
		res.append("Front [");
		for(int i = front; i != tail; i = (i + 1) % data.length) {
			res.append(data[i]);
			if((i + 1) % data.length != tail) {
				res.append(", ");
			}
		}
		res.append("] Tail");
		
		return res.toString();
	}

}
