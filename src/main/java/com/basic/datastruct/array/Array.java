package com.basic.datastruct.array;

public class Array<E> {
	
	private E[] data;
	
	private int size;

	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		this.data = (E[])new Object[capacity];
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
	
	public void addLast(E e) {
		add(size, e);
	}
	
	public void addFirst(E e) {
		add(0, e);
	}
	
	public void add(int index, E e) {
		if(size == data.length)
			throw new IllegalArgumentException("Add faild, Array is full!");
		
		if(index < 0 || index > size)
			throw new IllegalArgumentException("Add faild, index is illegal!");
		
		for(int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];
		
		data[index] = e;
		size++;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Add faild, index is illegal!");
		return data[index];
	}
	
	public void set(int index, E e) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Add faild, index is illegal!");
		
		data[index] = e;
	}
	
	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e))
				return true;
		}
		return false;
	}
	
	public int find(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}
	
	public E remove(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Remove faild, index is illegal!");
		
		E ret = data[index];
		for(int i = index + 1; i <= size; i++)
			data[i - 1] = data[i];
		
		size--;
		data[size] = null;
		return ret;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size - 1);
	}
	
	public void removeElement(E e) {
		int index = find(e);
		if(index != -1) {
			remove(index);
		}
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
