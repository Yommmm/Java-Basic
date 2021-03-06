package com.basic.leetcode;

/**
 * 编写一个程序判断给定的数是否为丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 示例 3:
 * <p>
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 * 说明：
 * <p>
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution263 {

    public static void main(String[] args) {
        Solution263 solution = new Solution263();
        System.out.println(solution.isUgly(12));
        System.out.println(solution.isUgly(15));
        System.out.println(solution.isUgly(16));
        System.out.println(solution.isUgly(17));
        System.out.println(solution.isUgly(18));
        System.out.println(solution.isUgly(20));
        System.out.println(solution.isUgly(21));
    }

    public boolean isUgly(int num) {
        if (0 == num) return false;

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            return false;
        }
        return true;
    }

}
