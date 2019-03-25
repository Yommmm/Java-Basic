package com.basic.datastruct.map;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4, 5, 5, 5};
		int[] nums2 = {3, 4, 5, 5, 5, 6, 6};
		int[] solution = new Solution().solution(nums1, nums2);
		System.out.println(solution.toString());
	}
	
	public int[] solution(int[] nums1, int[] nums2) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int num : nums1) {
			if(!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		
		List<Integer> ret = new ArrayList<>();
		for(int num : nums2) {
			if(map.containsKey(num)) {
				ret.add(num);
				map.put(num, map.get(num) - 1);
				if(map.get(num) == 0) {
					map.remove(num);
				}
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
