package com.basic.datastruct.queue;

import com.basic.datastruct.array.Array;

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> arr;

    public ArrayQueue(int capacity) {
        arr = new Array<>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public void enQueue(E e) {
        arr.addLast(e);
    }

    @Override
    public E deQueue() {
        return arr.removeFirst();
    }

    @Override
    public E getFront() {
        return arr.get(0);
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public int getCapacity() {
        return arr.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: Front [");
        for (int i = 0; i < arr.getSize(); i++) {
            res.append(arr.get(i));
            if (i != arr.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] Tail");

        return res.toString();
    }

}
