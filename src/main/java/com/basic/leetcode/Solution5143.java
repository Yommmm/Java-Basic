package com.basic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 * <p>
 * 考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。
 * <p>
 * 请你返回解压后的列表。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 */
public class Solution5143 {

    public static void main(String[] args) {
        Solution5143 solution = new Solution5143();
        System.out.println(Arrays.toString(solution.decompressRLElist(new int[]{1, 2, 3, 4})));
    }

    public int[] decompressRLElist(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            while (j > 0) {
                result.add(nums[i + 1]);
                j--;
            }

            i += 2;
        }

        int[] arr = new int[result.size()];
        for(int k = 0; k < result.size(); k ++) {
            arr[k] = result.get(k);
        }

        return arr;
    }

}
