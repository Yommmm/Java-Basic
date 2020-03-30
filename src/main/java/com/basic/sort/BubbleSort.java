package com.basic.sort;

/**
 * 冒泡排序
 *
 * @author Yom
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] list = new Integer[10];
        for (int i = 0; i < 10; i++) {
            list[i] = (int) Math.ceil(Math.random() * 1000);
            System.out.print(list[i] + " ");
        }
        System.out.println();
        list = bubbleSortWine(list);
        for (int i = 0; i < 10; i++) {
            System.out.print(list[i] + " ");
        }
    }

    /**
     * 普通冒泡
     *
     * @param list
     * @return
     */
    public static Integer[] bubbleSort(Integer[] list) {
        System.out.println("==========================================");
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    Integer temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                }
            }
            for (int k = 0; k < 10; k++) {
                System.out.print(list[k] + " ");
            }
            System.out.println();
        }
        System.out.println("==========================================");
        return list;
    }

    /**
     * 鸡尾酒冒泡
     *
     * @param list
     * @return
     */
    public static Integer[] bubbleSortWine(Integer[] list) {
        System.out.println("==========================================");
        Integer left = 0;
        Integer right = list.length - 1;
        while (left < right) {
            for (int l = left; l < right; l++) {
                if (list[l] > list[l + 1]) {
                    Integer temp = list[l + 1];
                    list[l + 1] = list[l];
                    list[l] = temp;
                }
            }
            right--;
            for (int r = right; r > left; r--) {
                if (list[r] < list[r - 1]) {
                    Integer temp = list[r - 1];
                    list[r - 1] = list[r];
                    list[r] = temp;
                }
            }
            left++;
            for (int k = 0; k < 10; k++) {
                System.out.print(list[k] + " ");
            }
            System.out.println();
        }
        System.out.println("==========================================");
        return list;
    }

}
