package com.basic.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        int[] nums = new int[]{1, 3, 5, 7, 9};

        int[] result = s.twoSum(nums, 8);
        System.out.println(result[0] + "," + result[1]);

        int[] result2 = s.twoSum2(nums, 8);
        System.out.println(result2[0] + "," + result2[1]);

        int[] nums3 = new int[]{3, 3};
        int[] result3 = s.twoSum2(nums3, 6);
        System.out.println(result3[0] + "," + result3[1]);

        int[] nums4 = new int[]{5, 6};
        int[] result4 = s.twoSum2(nums4, 11);
        System.out.println(result4[0] + "," + result4[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null == map.get(nums[i])) {
                map.put(nums[i], i);
            }
            int dif = target - nums[i];
            if (null != map.get(dif) && map.get(dif) != i) {
                return new int[]{map.get(dif), i};
            }
        }

        return null;
    }

}
