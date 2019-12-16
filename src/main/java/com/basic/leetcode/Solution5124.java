package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 5124. 顺次数  显示英文描述
 * 用户通过次数 560
 * 用户尝试次数 672
 * 通过次数 562
 * 提交次数 1149
 * 题目难度 Medium
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 *
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 *
 *
 *
 * 示例 1：
 *
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 示例 2：
 *
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 */
public class Solution5124 {

    public static void main(String[] args) {
        Solution5124 solution = new Solution5124();
        System.out.println(solution.sequentialDigits(1000, 13000));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        test(new StringBuilder(), low, high, result);
        result.sort((a, b) -> a-b);
        return result;
    }

    public void test(StringBuilder sb, int low, int high, List<Integer> result) {
        int start = 1;
        while (start < 10) {
            for(int i = start; i <= 9; i++) {
                sb.append(i);
                int temp = Integer.valueOf(sb.toString());
                if(temp >= low && temp <= high) {
                    result.add(temp);
                }
            }
            sb = new StringBuilder();
            start ++;
        }
    }

}
