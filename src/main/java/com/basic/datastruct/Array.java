package com.basic.datastruct;

public class Array {

	private int[] data;
	
	private int size;

	public Array(int capacity) {
		this.data = new int[capacity];
		this.size = 0;
	}
	
	public Array() {
		this(10);
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public boolean isEmpty() {
		return 0 == size;
	}
	
	public void addLast(int e) {
		add(size, e);
	}
	
	public void addFirst(int e) {
		add(0, e);
	}
	
	public void add(int index, int e) {
		if(size == data.length)
			throw new IllegalArgumentException("Add faild, Array is full!");
		
		if(index < 0 || index > size)
			throw new IllegalArgumentException("Add faild, index is illegal!");
		
		for(int i = size - 1; i >= index; i--)
			data[size + 1] = data[size];
		
		data[index] = e;
		size++;
	}
	
	public int get(int index) {
		if(index < 0 || index > size)
			throw new IllegalArgumentException("Add faild, index is illegal!");
		return data[index];
	}
	
	public void set(int index, int e) {
		if(index < 0 || index > size)
			throw new IllegalArgumentException("Add faild, index is illegal!");
		
		data[index] = e;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array size is %d, capacity is %d\n", size, data.length));
		res.append("[");
		for(int i = 0; i < size; i++) {
			res.append(data[i]);
			if(i != size - 1) {
				res.append(",");
			}
		}
		res.append("]");
		
		return res.toString();
	}
}
