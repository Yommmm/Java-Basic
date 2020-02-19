package com.basic.leetcode;

/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * <p>
 * 示例:
 * <p>
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution357 {

    public static void main(String[] args) {
        Solution357 solution = new Solution357();
        System.out.println(solution.countNumbersWithUniqueDigits(0));
        System.out.println(solution.countNumbersWithUniqueDigits(1));
        System.out.println(solution.countNumbersWithUniqueDigits(2));
        System.out.println(solution.countNumbersWithUniqueDigits(3));
        System.out.println(solution.countNumbersWithUniqueDigits(4));
        System.out.println(solution.countNumbersWithUniqueDigits(5));
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (0 == n) return 1;
        if (1 == n) return 10;
        if (2 == n) return 91;

        int result = 91;
        int ans = 81;

        /**
         * n位时：9*9*8*...*(9-n+3)*(9-n+2)
         * n-1位时：9*9*8*...*(9-n+3)
         */
        for (int i = 3; i <= n; i++) {
            ans = ans * (9 - i + 2);
            result += ans;
        }

        return result;
    }

}