package com.basic.leetcode;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution40 {

    public static void main(String[] args) {
        Solution40 solution = new Solution40();
        List<List<Integer>> lists = solution.combinationSum2(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        System.out.println(lists);

        List<List<Integer>> lists2 = solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println(lists2);

        List<List<Integer>> lists3 = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists3);
    }

    /**
     * 回溯法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        this.rc(target, candidates, 0, result, new ArrayList<>());

        return result;
    }

    public void rc(int target, int[] candidates, int startIndex, List<List<Integer>> result, List<Integer> temp) {
        // 递归终止条件1
        if (target < 0) {
            return;
        }

        // 递归终止条件2
        if (target == 0) {
            if (!result.contains(temp)) {
                result.add(new ArrayList<>(temp));
            }

            return;
        }

        // 多个元素的回溯
        for (int i = startIndex; i < candidates.length; i++) {
            temp.add(candidates[i]);
            rc(target - candidates[i], candidates, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
