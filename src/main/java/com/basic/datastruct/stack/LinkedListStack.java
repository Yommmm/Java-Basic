package com.basic.datastruct.stack;

import com.basic.datastruct.linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    private int size;

    public LinkedListStack() {
        this.linkedList = new LinkedList<E>();
        this.size = 0;
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
        size++;
    }

    @Override
    public E pop() {
        E e = linkedList.removeFirst();
        size--;
        return e;
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListStack: Pop[");
        res.append(linkedList);
        res.append("]");
        return res.toString();
    }

}
