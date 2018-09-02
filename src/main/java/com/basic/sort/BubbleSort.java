package com.basic.sort;

public class BubbleSort {

	public static void main(String[] args) {
		Integer[] list = new Integer[10];
		for(int i = 0; i < 10; i++) {
			list[i] = (int) Math.ceil(Math.random() * 1000);
			System.out.print(list[i] + " ");
		}
		System.out.println();
		list = bubbleSort(list);
		for(int i = 0; i < 10; i++) {
			System.out.print(list[i] + " ");
		}
	}
	
	public static Integer[] bubbleSort(Integer[] list) {
		System.out.println("==========================================");
		for(int i = 0; i < list.length - 1; i++) {
			for(int j = 0; j < list.length - i - 1; j++) {
				if(list[j] > list[j + 1]) {
					Integer temp = list[j +1];
					list[j + 1] = list[j];
					list[j] = temp;
				}
			}
			for(int k = 0; k < 10; k++) {
				System.out.print(list[k] + " ");
			}
			System.out.println();
		}
		System.out.println("==========================================");
		return list;
	}

}
