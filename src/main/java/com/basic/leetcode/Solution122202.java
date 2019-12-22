package com.basic.leetcode;

import java.util.Arrays;

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
public class Solution122202 {

    public static void main(String[] args) {
        Solution122202 solution = new Solution122202();
        solution.test(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4, 0);

//        System.out.println(solution.isPossibleDivide(new int[]{0, 2, 3, 3, 4, 4, 5, 6}, 4));
//        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
//        System.out.println(solution.isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
//        System.out.println(solution.isPossibleDivide(new int[]{3, 3, 2, 2, 1, 1}, 3));
//        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 4}, 3));
//        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 6}, 5));
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        if (k > nums.length || nums.length % k != 0) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 0; i < k; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                swap(nums, i + 1, i);
                i--;
            } else if (nums[i + 1] - nums[i] != 1) {
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[j] - nums[i] == 1) {
                        swap(nums, i + 1, j);
                        break;
                    }
                }
            }
        }

        int[] first = new int[k];
        int[] next = new int[nums.length - k];
        System.arraycopy(nums, 0, first, 0, k);
        System.arraycopy(nums, k, next, 0, nums.length - k);
        Arrays.sort(next);

        return isk(first, k) && isk(next, k);
    }

    public void test(int[] nums, int k, int start) {
        if(start >= nums.length - 1) {
            return;
        }

        int i;
        for (i = start; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                swap(nums, i + 1, i);
                i--;
            } else if (nums[i + 1] - nums[i] != 1) {
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[j] - nums[i] == 1) {
                        swap(nums, i + 1, j);
                        break;
                    }
                }
            }
        }

        test(nums, k, i);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean isk(int[] nums, int k) {
        int count = 0;
        int index = 0;
        while (index < nums.length - 1) {
            if (nums[index + 1] - nums[index] == 1) {
                count++;
            }
            index++;
        }

        return count >= k - 1;
    }

}
