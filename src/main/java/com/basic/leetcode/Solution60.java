package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution60 {

    public static void main(String[] args) {
        Solution60 solution = new Solution60();

        System.out.println(solution.getPermutation1(4, 9));
    }

    int count = 0;
    String result = null;

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        return this.permute(new ArrayList<>(), nums, k);
    }

    private String permute(List<Integer> temp, int[] nums, int k) {
        if (temp.size() == nums.length) {
            count++;
        }

        if (count == k) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : temp) {
                sb.append(i);
            }
            result = sb.toString();
        }

        for (int i = 0; null == result && i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            permute(temp, nums, k);
            temp.remove(temp.size() - 1);
        }

        return result;
    }

    public String getPermutation1(int n, int k) {
        // 阶乘数组
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // 输入数组
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder sb = new StringBuilder();
        k = k - 1;
        for (int i = n; i > 0; i--) {
            int group = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(nums.get(group));
            nums.remove(group);
        }
        return sb.toString();
    }
}
