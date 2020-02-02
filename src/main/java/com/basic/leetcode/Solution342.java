package com.basic.leetcode;

/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution342 {

    public static void main(String[] args) {
        Solution342 solution = new Solution342();
        System.out.println(solution.isPowerOfFour(16));
    }

    public boolean isPowerOfFour(int num) {
        return (num > 0) && (Math.log(num) / Math.log(2) % 2 == 0);
    }

}
