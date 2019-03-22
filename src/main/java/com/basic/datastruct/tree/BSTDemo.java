package com.basic.datastruct.tree;

import java.util.ArrayList;
import java.util.Random;

public class BSTDemo {

	public static void main(String[] args) {
		/*BST<Integer> bst = new BST<Integer>();
		Random random = new Random();
		
		for(int i = 0; i < 1000; i++) {
			bst.add(random.nextInt(10000));
		}
		
		bst.inOrder();
		System.out.println(bst.size);
		ArrayList<Integer> list = new ArrayList<>();
		while(!bst.isEmpty()) {
			list.add(bst.removeMin());
		}
		System.out.println(list);
		System.out.println(list.size());*/
		
		new BSTDemo().testDelNode();
		
//		System.out.println(bst.toString());
//		
//		bst.preOrderNR();
//		bst.preOrder();
//		bst.levelOrder();
//		bst.inOrder();
//		bst.postOrder();
//		
//		System.out.println(bst.minimumNR());
//		System.out.println(bst.minimum());
//		System.out.println(bst.maximumNR());
//		System.out.println(bst.maximum());
//		
//		bst.inOrder();
//		System.out.println(bst.removeMinNR());
//		bst.inOrder();
//		System.out.println(bst.removeMax());
//		bst.inOrder();
	}
	
	public void testDelNode() {
		BST<Integer> bst = new BST<>();
		bst.add(8);
		bst.add(7);
		bst.add(66);
		bst.add(1);
		bst.add(9);
		bst.add(3);
		bst.add(10);
		bst.add(88);
		bst.add(77);
		
		bst.inOrder();
		bst.remover(66);
		bst.inOrder();
		
	}
	
}
