package com.basic.datastruct.linkedlist;

public class LinkedList<E> {

	/**
	 * 虚拟头结点，方便队首插入元素
	 */
	private Node<E> dummyHead;
	
	private int size;
	
	public LinkedList() {
		dummyHead = new Node<E>();
		size = 0;
	}
	
	public void add(int index, E e) {
		if(index < 0 || index > size)
			throw new IllegalArgumentException("Add faild, index is illeagl!");
		
		Node<E> prev = dummyHead; 
		for(int i = 0; i < index; i++) {
			prev = prev.next;
		}
		
		prev.next = new Node<E>(e, prev.next);
		size++;
		
	}
	
	public void addLast(E e) {
		add(size, e);
	}
	
	public void addFirst(E e) {
		add(0, e);
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return 0 == size;
	}
	
	public E get(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get faild, index is illeagl!");
		
		Node<E> cur = dummyHead.next;
		for(int i = 0; i < index; i++) {
			cur = cur.next;
		}
		
		return cur.e;
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size - 1);
	}
	
	public void set(int index, E e) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Set faild, index is illeagl!");
		
		Node<E> cur = dummyHead.next;
		for(int i = 0; i < index; i++) {
			cur = cur.next;
		}
		
		cur.e = e;
	}
	
	public E remove(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get faild, index is illeagl!");
		
		Node<E> prev = dummyHead;
		for(int i = 0; i < index; i++) {
			prev = prev.next;
		}
		
		Node<E> delNode = prev.next;
		prev.next = delNode.next;
		delNode.next = null;
		
		size--;
		
		return delNode.e;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size - 1);
	}
	
	public boolean contains(E e) {
		
		Node<E> cur = dummyHead.next;
		while(cur != null) {
			if(cur.e.equals(e)) {
				return true;
			}
			cur = cur.next;
		}
		
		return false;
	}
	
	@SuppressWarnings("hiding")
	private class Node<E> {
		
		public E e;
		public Node<E> next;
		
		public Node(E e, Node<E> next) {
			this.e = e;
			this.next = next;
		}
		
		@SuppressWarnings("unused")
		public Node(E e) {
			this(e, null);
		}
		
		public Node() {
			this(null, null);
		}
		
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("LinkedList: Head [");
		
		Node<E> cur = dummyHead.next;
		while(cur != null) {
			res.append(cur.e + " -> ");
			cur = cur.next;
		}
		res.append("NULL ] Last");
		
		return res.toString();
	}
	
}
