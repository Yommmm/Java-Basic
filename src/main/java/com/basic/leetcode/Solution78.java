package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution78 {

    public static void main(String[] args) {
        Solution78 solution = new Solution78();

        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, result, new ArrayList<>());

        return result;
    }

    public void subsets(int[] nums, int start, List<List<Integer>> result, List<Integer> temp) {
        // 自然递归到底即可，无需设置递归终止条件，可以自动结束
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsets(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
