package com.basic.datastruct.avl;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<K extends Comparable<K>, V> {

    private Node root;

    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isBST() {
        List<K> keys = new ArrayList<>();
        inOrder(keys);

        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(List<K> keys) {
        inOrder(root, keys);
    }

    public void inOrder(Node node, List<K> keys) {
        if (null == node)
            return;

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    /**
     * 根据key从树中获取节点数据
     *
     * @param key
     * @return
     */
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    /**
     * 是否包含该节点
     *
     * @param key
     * @return
     */
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * 重置赋值
     *
     * @param key
     * @param newValue
     */
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    /**
     * 从某个节点的子树中查找 key 对应的节点
     *
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (null == node) {
            return null;
        }

        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return getNode(node.left, key);
        }
    }

    /**
     * 最小值
     *
     * @return
     */
    public V minimum() {
        return minimum(root).value;
    }

    private Node minimum(Node node) {
        if (null == node.left)
            return node;
        return minimum(node.left);
    }

    /**
     * 最大值
     *
     * @return
     */
    public V maximum() {
        return maximum(root).value;
    }

    private Node maximum(Node node) {
        if (null == node.right)
            return node;
        return maximum(node.right);
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 向二分搜索树中添加元素
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            // 重复key更新
            node.value = value;
        }

        // 更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            System.out.println("unbalanced : " + balanceFactor);

        return node;
    }

    /**
     * 从二分搜索树中删除键为key的节点
     *
     * @param key
     * @return
     */
    public V remove(K key) {

        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    /**
     * 获取节点树高度
     *
     * @param node
     * @return
     */
    private int getHeight(Node node) {
        if (node == null)
            return 0;

        return node.height;
    }

    /**
     * 获取当前节点平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;

        return getHeight(node.left) - getHeight(node.right);
    }

    private class Node {

        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

}
