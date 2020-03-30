package com.basic.datastruct.heap;

import com.basic.datastruct.array.Array;

public class MinHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MinHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public MinHeap() {
        this.data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (0 == index)
            throw new IllegalArgumentException("index-0 doesn't exist parent node!");

        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E extractMin() {
        E ret = findMin();
        data.removeFirst();

        return ret;
    }

    public E findMin() {
        if (0 == data.getSize())
            throw new IllegalArgumentException("MaxHeap is empty!");
        return data.get(0);
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) < 0)
                j = rightChild(k);

            if (data.get(k).compareTo(data.get(j)) <= 0)
                break;

            data.swap(k, j);
            k = j;
        }
    }

    public E replace(E e) {
        E ret = findMin();
        data.set(0, e);
        siftDown(0);

        return ret;
    }

    public void heapify(E[] arr) {
        this.data = new Array<>(arr);
        for (int i = parent(data.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public String toString() {
        return "MinHeap " + data;
    }

}
