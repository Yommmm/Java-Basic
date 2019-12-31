package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution136 {

    public static void main(String[] args) {
        Solution136 solution = new Solution136();
        System.out.println(solution.singleNumber1(new int[]{1, 1, 2, 3, 3, 4, 4}));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (1 == map.get(key)) {
                return key;
            }
        }

        return -1;
    }

    public int singleNumber1(int[] nums) {
        int num = nums[0];

        for(int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }

        return num;
    }

}
