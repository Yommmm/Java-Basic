package com.basic.datastruct.set;

import com.basic.datastruct.linkedlist.LinkedList;

public class LinkedListSet<E extends Comparable<E>> implements Set<E> {
	
	private LinkedList<E> list;
	
	public LinkedListSet() {
		this.list = new LinkedList<>();
	}

	@Override
	public void add(E e) {
		if(!list.contains(e))
			list.add(0, e);
	}

	@Override
	public void remove(E e) {
		
	}

	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
