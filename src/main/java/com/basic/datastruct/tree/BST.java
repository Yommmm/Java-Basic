package com.basic.datastruct.tree;

import java.util.LinkedList;
import java.util.Queue;
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
	
	/**
	 * 前序非递归
	 */
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
	
	/**
	 * 前序递归
	 */
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
	
	/**
	 * 中序遍历
	 */
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
	
	/**
	 * 后续遍历
	 */
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
	
	public void levelOrder() {
		Queue<Node<E>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node<E> cur = q.remove();
			System.out.print(cur.e + ", ");
			
			if(null != cur.left) {
				q.add(cur.left);
			}
			if(null != cur.right) {
				q.add(cur.right);
			}
		}
	}
	
	/**
	 * 找最小值
	 * @return
	 */
	public E minimumNR() {
		Node<E> node = root;
		while(null != node) {
			if(null == node.left) {
				return node.e;
			}
			node = node.left;
		}
		return null;
	}
	
	public E minimum() {
		return minimum(root).e;
	}
	
	private Node<E> minimum(Node<E> node) {
		if(null == node.left)
			return node;
		
		return minimum(node.left);
	}
	/**************************/
	
	/**
	 * 找最大值
	 * @return
	 */
	public E maximumNR() {
		Node<E> node = root;
		while(null != node) {
			if(null == node.right) {
				return node.e;
			}
			node = node.right;
		}
		return null;
	}
	
	public E maximum() {
		return maximum(root).e;
	}
	
	private Node<E> maximum(Node<E> node) {
		if(null == node.right)
			return node;
		
		return maximum(node.right);
	}
	/**************************/

	/**
	 * 删除最小值
	 * @return
	 */
	public E removeMinNR() {
		Node<E> node = root;
		if(null == node.left) {
			root = null;
			size --;
			return node.e;
		}
		
		while(null != node.left.left) {
			node = node.left;
		}
		
		Node<E> delNode = node.left;
		node.left = delNode.right;
		
		return delNode.e;
	}
	
	public E removeMin() {
		if(size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
		
		E ret = minimum();
		root = removeMin(root);
		return ret;
	}
	
	private Node<E> removeMin(Node<E> node) {
		if(null == node.left) {
			Node<E> rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}
		
		node.left = removeMin(node.left);
		return node;
	}
	/****************************/
	
	/**
	 * 删除最大值
	 * @return
	 */
	public E removeMaxNR() {
		Node<E> node = root;
		while(null != node) {
			if(null == node.right) {
				Node<E> delNode = node;
				if(null != node.left) {
					node = node.left;
				} else {
					node = null;
				}
				return delNode.e;
			}
			node = node.right;
		}
		return null;
	}
	
	public E removeMax() {
		if(size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
		
		E ret = maximum();
		root = removeMax(root);
		return ret;
	}
	
	private Node<E> removeMax(Node<E> node) {
		if(null == node.right) {
			Node<E> leftNode = node.left;
			node.left = null;
			size --;
			return leftNode;
		}
		
		node.right = removeMax(node.right);
		return node;
	}
	/****************************/
	
	public void remove(E e) {
		root = remove(root, e);
	}
	
	private Node<E> remove(Node<E> node, E e) {
		if(null == node)
			return null;
		
		if(e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			return node;
		} else if(e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
			return node;
		} else { // e.compareTo(node.e) == 0
			
			// 如果左子树为空，直接返回delNode的【右子树】给delNode父亲的子节点
			if(null == node.left) {
				Node<E> rightNode = node.right;
				node.right = null;
				size --;
				return rightNode;
			}
			
			// 如果右子树为空，直接返回delNode的【左子树】给delNode父亲的子节点
			if(null == node.right) {
				Node<E> leftNode = node.left;
				node.left = null;
				size --;
				return leftNode;
			}
			
			// 左右子树都不为空的情况下，选中右子树的最小节点【后继】或者左子树的最大节点【前驱】
			Node<E> successor = minimum(node.right); // 找到右子树那个最小的后继节点
			successor.right = removeMin(node.right); // 删掉那个右子树上最小的后继节点
			successor.left = node.left;
			
			node.left = node.right = null; // delNode与树脱离关系
			
			return successor;
		}
		
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
