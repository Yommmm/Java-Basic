package com.basic.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        System.out.println(solution.longestPalindrome("bbbb"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        String result = "";

        for (int center = 0; center < 2 * len - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                result = result.length() > (right - left) ? result : s.substring(left, right + 1);
                left--;
                right++;
            }

        }

        return result;
    }

}
