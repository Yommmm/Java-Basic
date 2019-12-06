package com.basic.leetcode;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution39 {

    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        List<List<Integer>> lists = solution.combinationSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        System.out.println(lists);
    }

    /**
     * 回溯法
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            result.add(new ArrayList<>(temp));
            return;
        }

        // 多个元素的回溯
        for (int i = startIndex; i < candidates.length; i++) {
            temp.add(candidates[i]);
            rc(target - candidates[i], candidates, i, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
