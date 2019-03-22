package com.basic.datastruct.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		for(int i = 0; i < 5; i++) {
			linkedList.addFirst(i);
			System.out.println(linkedList);
		}
		
		linkedList.add(2, 666);
		System.out.println(linkedList);
		
		linkedList.set(2, 777);
		linkedList.removeElement(666);
		System.out.println(linkedList);
		
		System.out.println(linkedList.contains(777));
		System.out.println(linkedList.contains(888));
		
		linkedList.remove(2);
		System.out.println(linkedList);
		
		linkedList.removeFirst();
		System.out.println(linkedList);
		
		linkedList.removeLast();
		System.out.println(linkedList);
	}
	
}
