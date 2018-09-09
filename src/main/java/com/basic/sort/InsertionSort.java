package com.basic.sort;

/**
 * 插入排序
 * @author Yom
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		Integer[] list = new Integer[10];
		for(int i = 0; i < 10; i++) {
			list[i] = (int) Math.ceil(Math.random() * 1000);
			System.out.print(list[i] + " ");
		}
		System.out.println();
		list = insertion(list);
		for(int i = 0; i < 10; i++) {
			System.out.print(list[i] + " ");
		}
	}
	
	public static Integer[] insertion(Integer[] list) {
		System.out.println("====================================");
		/**
		 * 左手上有一张牌，从抓的第二张牌开始
		 */
		for(int i = 1; i < list.length; i++) {
			// 抓在右手上的牌
			int rightValue = list[i];
			// 左手上从右往左数第一张牌的下标
			int leftIndex = i - 1;
			// 由于左手上的牌是有序的，只要判断是否小于右边的牌就行
			while(leftIndex >= 0 && list[leftIndex] > rightValue) {
				// 满足条件的左手牌右移一位，移到最后移不动就放第一位
				list[leftIndex + 1] = list[leftIndex];
				leftIndex --;
			}
			// 右手抓的那张牌放进来，放到while条件移出来的那个空位上
			list[leftIndex + 1] = rightValue;
			
			for(int k = 0; k < 10; k++) {
				System.out.print(list[k] + " ");
			}
			System.out.println();
		}
		System.out.println("====================================");
		return list;
	}
	
}
