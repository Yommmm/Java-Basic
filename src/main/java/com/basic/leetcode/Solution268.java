package com.basic.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution268 {

    public static void main(String[] args) {
        Solution268 solution = new Solution268();
        System.out.println(solution.missingNumber1(new int[]{}));
        System.out.println(solution.missingNumber1(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(solution.missingNumber1(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        } else if (nums[0] != 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int expectedNumCount = nums.length + 1;
        for (int i = 0; i < expectedNumCount; i++) {
            if (!set.contains(i)) return i;
        }

        return -1;
    }

}
