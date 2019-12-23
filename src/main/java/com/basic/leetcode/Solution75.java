package com.basic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution75 {

    public static void main(String[] args) {
        Solution75 solution = new Solution75();

        solution.sortColors2(new int[]{2, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1, 1, 1, 1});
        solution.sortColors2(new int[]{2, 0, 0});
    }

    public void sortColors(int[] nums) {
        System.out.println(Arrays.toString(nums));
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int num = 0;
        int index = 0;
        while (num < 3) {
            Integer end = map.getOrDefault(num, 0) + index;
            while (index < end) {
                nums[index] = num;
                index++;
            }
            num++;
        }

        System.out.println(Arrays.toString(nums));
    }

    public void sortColors2(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int left = 0;
        int right = nums.length - 1;

        int cur = 0;

        while (cur <= right) {
            if (nums[cur] > 1) {
                swap(nums, cur, right);
                right--;
            } else if (nums[cur] < 1) {
                swap(nums, cur, left);
                left++;
                cur++;
            } else {
                cur++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
