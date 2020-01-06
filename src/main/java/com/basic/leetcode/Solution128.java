package com.basic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution128 {

    public static void main(String[] args) {
        Solution128 solution = new Solution128();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longestLen = 0;
        for (int num : set) {
            // 找到连续串串的最小的那个值
            if (!set.contains(num - 1)) {
                int cur = num;
                int curLen = 1;

                // 再从小往大找
                while (set.contains(cur + 1)) {
                    cur = cur + 1;
                    curLen += 1;
                }

                longestLen = Math.max(longestLen, curLen);
            }
        }

        return longestLen;
    }

}
