package com.basic.datastruct.tree;

public class BSTDemo {

	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.add(5);
		bst.add(3);
		bst.add(6);
		bst.add(8);
		bst.add(4);
		bst.add(2);
		
//		System.out.println(bst.contains(90));
//		System.out.println(bst.contains(80));
		
		System.out.println(bst.toString());
		bst.preOrder();
		bst.inOrder();
		bst.postOrder();
	}
	
}
