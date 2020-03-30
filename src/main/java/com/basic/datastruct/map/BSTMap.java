package com.basic.datastruct.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private int size;

    private Node root;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (null == node) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else { // key.compareTo(node.key) == 0
            node.value = value;
        }

        return node;
    }

    private Node getNode(Node node, K key) {
        if (null == node) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        }

        return null;
    }

    @Override
    public V remove(K key) {
        if (null == getNode(root, key))
            throw new IllegalArgumentException(key + "doesn't exist!");

        Node node = remove(root, key);
        return null == node ? null : node.value;
    }

    private Node remove(Node node, K key) {
        if (null == node)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { // e.compareTo(node.e) == 0

            // 如果左子树为空，直接返回delNode的【右子树】给delNode父亲的子节点
            if (null == node.left) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 如果右子树为空，直接返回delNode的【左子树】给delNode父亲的子节点
            if (null == node.right) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 左右子树都不为空的情况下，选中右子树的最小节点【后继】或者左子树的最大节点【前驱】
            Node successor = minimum(node.right); // 找到右子树那个最小的后继节点
            successor.right = removeMin(node.right); // 删掉那个右子树上最小的后继节点
            successor.left = node.left;

            node.left = node.right = null; // delNode与树脱离关系

            return successor;
        }

    }

    private Node minimum(Node node) {
        if (null == node.left)
            return node;

        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (null == node.left) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;

    }

    @Override
    public boolean contains(K key) {
        return null != getNode(root, key);
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return null == node ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (null == node)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.left = null;
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }

    }

}
