package com.basic.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution9 {

    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        System.out.println(solution.isPalindrome(123));
    }

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        int palindrome = 0;
        int standand = x;
        while(standand != 0) {
            palindrome = palindrome * 10 + (standand % 10);
            standand = standand / 10;
        }

        return palindrome == x;
    }

}
