package com.basic.datastruct.queue;

public class LinkedListQueue<E> implements Queue<E> {

    private Node<E> head, tail;

    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enQueue(E e) {
        if (tail == null) {
            tail = new Node<>(e);
            head = tail;
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty())
            throw new IllegalArgumentException("Connot dequeue, Queue is empty!");

        Node<E> retNode = head;
        head = head.next;
        retNode.next = null;

        if (head == null)
            tail = null;

        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Connot dequeue, Queue is empty!");
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("hiding")
    private class Node<E> {

        public E e;
        public Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @SuppressWarnings("unused")
        public Node() {
            this(null, null);
        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: Head [");
        Node<E> cur = head;
        while (cur != null) {
            res.append(cur.e + " <- ");
            cur = cur.next;
        }
        res.append("NULL ] Tail");
        return res.toString();
    }

}
