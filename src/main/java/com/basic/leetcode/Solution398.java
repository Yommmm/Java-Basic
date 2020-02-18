package com.basic.leetcode;

import java.util.Random;

public class Solution398 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution solution = new Solution(nums);

        // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
        System.out.println(solution.pick(3));

        // pick(1) 应该返回 0。因为只有nums[0]等于1。
        System.out.println(solution.pick(1));
    }

}

class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.random = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target) {
                count++;
                if (Math.abs(random.nextInt() % count) == 0) index = i;
            }
        }
        return index;
    }
}