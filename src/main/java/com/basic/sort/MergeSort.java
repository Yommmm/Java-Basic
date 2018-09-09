package com.basic.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 
 * @author Yom
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		Integer[] list = new Integer[10];
		for (int i = 0; i < 10; i++) {
			list[i] = (int) Math.ceil(Math.random() * 1000);
		}
		System.out.println(Arrays.toString(list));
		
		mergeSortRecursion(list, 0, 9);
		
		System.out.println(Arrays.toString(list));
	}

	public static void mergeSortRecursion(Integer[] list, int left, int right) {
		if (left != right) {
			int mid = (left + right) / 2;
			mergeSortRecursion(list, left, mid);
			mergeSortRecursion(list, mid + 1, right);
			merge(list, left, mid, right);
			System.out.println(Arrays.toString(list));
		}
	}

	public static void merge(Integer[] list, int left, int mid, int right) {
		int length = right - left + 1;
		Integer[] temp = new Integer[length];
		int index = 0;
		int i = left;    // 前一数组的起始元素
		int j = mid + 1; // 后一数组的起始元素
		while (i <= mid && j <= right) {
			temp[index++] = list[i] <= list[j] ? list[i++] : list[j++]; // 带等号保证归并排序的稳定性
		}
		while (i <= mid) {
			temp[index++] = list[i++];
		}
		while (j <= right) {
			temp[index++] = list[j++];
		}
		for (int k = 0; k < length; k++) {
			list[left++] = temp[k];
		}
	}

}
