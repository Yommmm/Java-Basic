package com.basic.leetcode;

import java.util.Arrays;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution287 {

    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }

        return -1;
    }

    public void quickSort(int[] list, int left, int right) {
        if (left < right) {
            int rightIndex = partition(list, left, right);
            quickSort(list, left, rightIndex - 1);
            quickSort(list, rightIndex + 1, right);
        }
    }

    /**
     * @param list
     * @param left
     * @param right
     * @return
     */
    public Integer partition(int[] list, int left, int right) {
        int mid = list[left];
        int cur = left + 1;

        for (int i = cur; i <= right; i++) {
            if (list[i] < mid) {
                swap(list, cur, i);
                cur++;
            }
        }
        swap(list, cur - 1, left);

        return cur - 1;
    }

    public void swap(int[] list, int left, int right) {
        int temp = list[left];
        list[left] = list[right];
        list[right] = temp;
    }

}
