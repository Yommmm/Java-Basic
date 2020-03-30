package com.basic.datastruct.map;

public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (null != cur) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (null == node) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (null != prev.next) {
            if (prev.next.key.equals(key)) {
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;

                size--;
                return delNode.value;
            }

            prev = prev.next;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return null != getNode(key);
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return null == node ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (null == node)
            throw new IllegalArgumentException(key + "doesn't exist!");

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
        public Node next;

        public Node(K key, V value, LinkedListMap<K, V>.Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null);
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }

    }

}
