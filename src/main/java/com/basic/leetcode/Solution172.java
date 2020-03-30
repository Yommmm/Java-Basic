package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution172 {

    public static void main(String[] args) {
        Solution172 solution = new Solution172();
        System.out.println(solution.trailingZeroes(3));
        System.out.println(solution.trailingZeroes(5));
        System.out.println(solution.trailingZeroes(25));
    }

    /**
     * 一个5就对应一个0
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            count += (n = n / 5);
        }

        return count;
    }

}
