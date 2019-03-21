package com.basic.datastruct.tree;

import java.util.Stack;

public class BST<E extends Comparable<E>> {

	private Node<E> root;
	
	int size;

	public BST() {
		this.root = null;
		this.size = 0;
	}
	
	public void add(E e) {
		root = add(root, e);
	}
	
	/*private void add(Node<E> node, E e) {
		if(e.equals(node.e)) {
			return;
		} else if(e.compareTo(node.e) < 0 && node.left == null) {
			node.left = new Node<E>(e);
			size ++;
			return;
		} else if(e.compareTo(node.e) > 0 && node.right == null) {
			node.right = new Node<E>(e);
			size ++;
			return;
		}
		
		if(e.compareTo(node.e) < 0) {
			add(node.left, e);
		} else {
			add(node.right, e);
		}
		
	}*/
	
	private Node<E> add(Node<E> node, E e) {
		if(null == node) {
			size ++;
			return new Node<E>(e);
		}
		
		if(e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		} else if(e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}
		
		return node;
	}
	
	public boolean contains(E e) {
		return contains(root, e);
	}
	
	private boolean contains(Node<E> node, E e) {
		if(null == node) 
			return false;
		
		if(e.compareTo(node.e) == 0)
			return true;
		
		if(e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		} else {
			return contains(node.right, e);
		}
		
	}
	
	public void preOrderNR() {
		Stack<Node<E>> stack = new Stack<>();
		
		stack.push(root);
		while(!stack.isEmpty()) {
			Node<E> cur = stack.pop();
			System.out.print(cur.e + ", ");
			
			if(null != cur.right) {
				stack.push(cur.right);
			}
			if(null != cur.left) {
				stack.push(cur.left);
			}
		}
	}
	
	public void preOrder() {
		preOrder(root);
		System.out.println("\n");
	}
	
	private void preOrder(Node<E> node) {
		if(null == node)
			return;
		
		System.out.print(node.e + ", ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder() {
		inOrder(root);
		System.out.println("\n");
	}
	
	private void inOrder(Node<E> node) {
		if(null == node)
			return;
		
		inOrder(node.left);
		System.out.print(node.e + ", ");
		inOrder(node.right);
	}
	
	public void postOrder() {
		postOrder(root);
		System.out.println("\n");
	}
	
	private void postOrder(Node<E> node) {
		if(null == node)
			return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.e + ", ");
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings("hiding")
	private class Node<E> {
		
		E e;
		Node<E> left, right;
		
		public Node(E e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
		
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		
		return res.toString();
	}

	private void generateBSTString(Node<E> node, int depth, StringBuilder res) {
		if(null == node) {
			res.append(generateDepthString(depth) + "null \n");
			return;
		}
		
		res.append(generateDepthString(depth) + node.e + " \n");
		
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);
	}

	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < depth; i++)
			res.append("--");
			
		return res.toString();
	}
	
}
