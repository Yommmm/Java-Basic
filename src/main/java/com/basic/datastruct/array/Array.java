package com.basic.datastruct.array;

/**
 * 动态数组
 *
 * @param <E>
 */
public class Array<E> {

    private E[] data;

    private int size;

    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public Array(E[] arr) {
        this.data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.data[i] = arr[i];
        }
        this.size = arr.length;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
//		if(size == data.length)
//			throw new IllegalArgumentException("Add faild, Array is full!");

        if (size == data.length)
            resize(data.length << 1);

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add faild, index is illegal!");

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add faild, index is illegal!");
        return data[index];
    }

    public E getFirst() {
        return data[0];
    }

    public E getLast() {
        return data[size - 1];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add faild, index is illegal!");

        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove faild, index is illegal!");

        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];

        size--;
        data[size] = null;

        /**
         * Eager size <= data.length >> 1
         * Lazy size <= data.length >> 2
         */
        if (size <= data.length >> 2 && data.length >> 1 != 0)
            resize(data.length >> 1);

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size)
            throw new IllegalArgumentException("Index is illegal!");

        E temp = null;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size is %d, capacity is %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }
}
