package com.basic.leetcode;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * <p>
 * 示例 1: 
 * <p>
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: [0,1]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution201 {

    public static void main(String[] args) {
        Solution201 solution = new Solution201();
        System.out.println(solution.rangeBitwiseAnd(5, 7));
    }

    public int rangeBitwiseAnd(int m, int n) {
        if (0 == m) return 0;

        while (m < n) {
            n &= n - 1;
            System.out.println(n);
        }

        return n;
    }

}
