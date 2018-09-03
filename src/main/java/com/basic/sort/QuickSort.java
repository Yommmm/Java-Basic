package com.basic.sort;

public class QuickSort {

	public static void main(String[] args) {
		Integer[] list = new Integer[10];
		for(int i = 0; i < 10; i++) {
			list[i] = (int) Math.ceil(Math.random() * 1000);
		}
		System.out.print(list);
		
		quickSort(list, 0, list.length - 1);
		
		
		System.out.print(list);
	}
	
	public static void quickSort(Integer[] list, Integer left, Integer right) {
		while(left < right) {
			System.out.println(list);
			int rightIndex = partition(list, left, right);
			quickSort(list, left, rightIndex - 1);
			quickSort(list, right + 1, right);
		}
	}
	
	public static Integer partition(Integer[] list, Integer left, Integer right) {
		Integer rightValue = list[right];
		Integer tail = left - 1;
		
		for(int i = left; i < right; i++) {
			if(list[i] <= rightValue) {
				swap(list, ++tail, i);
			}
		}
		swap(list, tail + 1, right);
		
		return tail + 1;
	}
	
	public static void swap(Integer[] list, Integer left, Integer right) {
		int temp = list[left];
		list[left] = list[right];
		list[right] = temp;
	}
	
}
