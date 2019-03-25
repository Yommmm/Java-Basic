package com.basic.datastruct.set;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4, 5};
		int[] nums2 = {3, 4, 5, 6, 6};
		int[] solution = new Solution().solution(nums1, nums2);
		System.out.println(solution.toString());
	}
	
	public int[] solution(int[] nums1, int[] nums2) {
		TreeSet<Integer> set = new TreeSet<>();
		for(int num : nums1) {
			set.add(num);
		}
		
		List<Integer> ret = new ArrayList<>();
		for(int num : nums2) {
			if(set.contains(num)) {
				ret.add(num);
				set.remove(num);
			}
		}
		
		int[] retArr = new int[ret.size()];
		int i = 0;
		for(Integer a : ret) {
			retArr[i] = a;
			i++;
		}
		return retArr;
	}
	
}
