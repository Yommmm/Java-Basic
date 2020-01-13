package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

import java.util.Arrays;

/**
 *
 */
public class Solution283 {

    public static void main(String[] args) {
        Solution283 solution = new Solution283();
        solution.moveZeroes(new int[]{0, 0, 3, 4, 0, 6, 7, 8});
    }

    public void moveZeroes(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (0 != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        for (int i = 1; i <= nums.length - slow; i++) {
            nums[nums.length - i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }
}
