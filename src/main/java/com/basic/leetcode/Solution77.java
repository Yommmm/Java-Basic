package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution77 {

    public static void main(String[] args) {
        Solution77 solution = new Solution77();
        System.out.println(solution.combine(9, 8));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (k == 0) {
            result.add(temp);
            return result;
        }

        combine(1, n, k, result, new ArrayList<>());
        return result;
    }

    private void combine(int start, int n, int k, List<List<Integer>> result, List<Integer> temp) {
        if (0 == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            temp.add(i);
            combine(i + 1, n, k - 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
