package com.basic.datastruct.heap;

import java.util.Random;

public class MinHeapDemo {

    public static void main(String[] args) {
//		test1();
//		test2();
        test3();
    }

    public static void test1() {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.add(99);
        heap.add(88);
        heap.add(77);
        heap.add(66);
        heap.add(55);
        heap.add(44);
        heap.add(33);
        heap.add(22);
        heap.add(11);
        System.out.println(heap.toString());

        heap.add(100);
        heap.add(101);
        System.out.println(heap.toString());

        heap.extractMin();
        System.out.println(heap.toString());
    }

    public static void test2() {
        long startTime = System.nanoTime();
        int count = 10000000;
        MinHeap<Integer> heap = new MinHeap<>();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        long endTime = System.nanoTime();

        System.out.println("ADD: " + (endTime - startTime) / 1000000000.0);

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            Integer extractMax = heap.extractMin();
            arr[i] = extractMax;
        }

        for (int i = 0; i < count - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                throw new RuntimeException("illegal!");
            }
        }

    }

    public static void test3() {
        long startTime = System.nanoTime();
        int count = 10;
        MinHeap<Integer> heap = new MinHeap<>();
        Integer[] testArr = new Integer[count];

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            testArr[i] = (random.nextInt(Integer.MAX_VALUE));
        }
        heap.heapify(testArr);
        long endTime = System.nanoTime();

        System.out.println("HEAPIFY: " + (endTime - startTime) / 1000000000.0);

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            Integer extractMax = heap.extractMin();
            System.out.println(extractMax);
            arr[i] = extractMax;
        }

        for (int i = 0; i < count - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                throw new RuntimeException("illegal!");
            }
        }

    }

}
