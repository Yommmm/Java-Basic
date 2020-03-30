package com.basic.sort;

/**
 * 选择排序
 *
 * @author Yom
 */
public class SelectionSort {

    public static void main(String[] args) {
        Integer[] list = new Integer[10];
        for (int i = 0; i < 10; i++) {
            list[i] = (int) Math.ceil(Math.random() * 1000);
            System.out.print(list[i] + " ");
        }
        System.out.println();
        list = selection(list);
        for (int i = 0; i < 10; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static Integer[] selection(Integer[] list) {
        System.out.println("====================================");
        for (int i = 0; i < list.length - 1; i++) {
            /**
             * 以第i个数为基准，选出待排序序列中最小的值
             * 选出最小值的下标
             * 循环选出待排序中最小的
             */
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = list[i];
                list[i] = list[min];
                list[min] = temp;
            }
            for (int k = 0; k < 10; k++) {
                System.out.print(list[k] + " ");
            }
            System.out.print("min: " + list[min] + " i: " + list[i]);
            System.out.println();
        }
        System.out.println("====================================");
        return list;
    }

}
