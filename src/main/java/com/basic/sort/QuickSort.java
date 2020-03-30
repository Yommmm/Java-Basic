package com.basic.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] list = new Integer[10];
        for (int i = 0; i < 10; i++) {
            list[i] = (int) Math.ceil(Math.random() * 1000);
            System.out.print(list[i] + " ");
        }
//		partition(list, 0, list.length - 1);
        quickSort(list, 0, list.length - 1);

        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static void quickSort(Integer[] list, Integer left, Integer right) {
        System.out.println("left: " + left + " right: " + right);
        if (left < right) {
            int rightIndex = partition(list, left, right);
            quickSort(list, left, rightIndex - 1);
            quickSort(list, rightIndex + 1, right);
        }
    }

    /**
     * @param list
     * @param left
     * @param right
     * @return
     */
    public static Integer partition(Integer[] list, Integer left, Integer right) {
        /**
         * 以第一个数为基准
         * 第二个数开始遍历
         * 如果有比基准小的，就交换第二个数和那个数的值
         * 依次类推第三第四个数交换值
         * 分成两堆大小值之后，基准放中间
         * 两堆再次分堆
         */
        Integer signValue = list[left];
        Integer tail = left + 1;

        for (int i = tail; i <= right; i++) {
            if (list[i] < signValue) {
                swap(list, tail, i);
                tail++;
                System.out.println(Arrays.asList(list).toString());
            }
        }
        swap(list, tail - 1, left);
        System.out.println(Arrays.asList(list).toString());

        return tail - 1;
    }

    public static void swap(Integer[] list, Integer left, Integer right) {
        int temp = list[left];
        list[left] = list[right];
        list[right] = temp;
    }

}
