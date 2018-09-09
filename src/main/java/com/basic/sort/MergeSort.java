package com.basic.sort;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		Integer[] list = new Integer[10];
		for(int i = 0; i < 10; i++) {
			list[i] = (int) Math.ceil(Math.random() * 1000);
		}
		System.out.println(Arrays.toString(list));
		
		
	}

}
