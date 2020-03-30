package com.basic.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 True；否则，返回 False。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 * 输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * 输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 * 示例 3：
 * <p>
 * 输入：nums = [3,3,2,2,1,1], k = 3
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 */
public class Solution5292 {

    public static void main(String[] args) {
        Solution5292 solution = new Solution5292();
        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
        System.out.println(solution.isPossibleDivide(new int[]{0, 2, 3, 3, 4, 4, 5, 6}, 4));
        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
        System.out.println(solution.isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
        System.out.println(solution.isPossibleDivide(new int[]{3, 3, 2, 2, 1, 1}, 3));
        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 4}, 3));
        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 6}, 5));
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        // 如果数组长度不是 k 的倍数，不满足分组条件
        if (nums.length % k != 0) {
            return false;
        }

        // 排序
        Arrays.sort(nums);

        // 申明优先队列，数组元素进入堆内
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);
        for (int num : nums) {
            minHeap.offer(num);
        }

        while (!minHeap.isEmpty()) {
            // 出堆的第一个元素
            Integer top = minHeap.poll();

            // 每次出k个
            for (int i = 1; i < k; i++) {
                // 如果出比第i个元素大1的数失败，返回false
                if (!minHeap.remove(top + i)) {
                    return false;
                }
            }
        }

        return true;
    }

}
