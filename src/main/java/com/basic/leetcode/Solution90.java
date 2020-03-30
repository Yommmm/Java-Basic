package com.basic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution90 {

    public static void main(String[] args) {
        Solution90 solution = new Solution90();
        List<List<Integer>> lists = solution.subsetsWithDup(new int[]{2, 1, 2, 2});

        lists.stream().forEach(System.out::println);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, result, new ArrayList<>());

        return result;
    }

    public void subsetsWithDup(int[] nums, int start, List<List<Integer>> result, List<Integer> temp) {
        // 自然递归到底即可，无需设置递归终止条件，可以自动结束
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            // 同一层递归调用的循环中，每个数字只能只能出现一次
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            subsetsWithDup(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
