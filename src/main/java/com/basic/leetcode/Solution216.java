package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution216 {

    public static void main(String[] args) {
        Solution216 solution = new Solution216();
        System.out.println(solution.combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        this.backtrace(1, k, n, result, new ArrayList<>());
        return result;
    }

    public void backtrace(int start, int k, int n, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() > k) {
            return;
        } else if (temp.size() == k) {
            if (0 == n) {
                result.add(new ArrayList<>(temp));
                return;
            } else {
                return;
            }
        }

        for (int i = start; i < 10; i++) {
            temp.add(i);
            backtrace(i + 1, k, n - i, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
