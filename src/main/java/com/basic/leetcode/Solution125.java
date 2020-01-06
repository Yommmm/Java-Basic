package com.basic.leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution125 {

    public static void main(String[] args) {
        Solution125 solution = new Solution125();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;

            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            start++;
            end--;
        }

        return true;
    }

}
