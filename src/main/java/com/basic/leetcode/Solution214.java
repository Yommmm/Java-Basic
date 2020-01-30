package com.basic.leetcode;

/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1:
 *
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 *
 * 输入: "abcd"
 * 输出: "dcbabcd"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * string shortestPalindrome(string s)
 * {
 *     int n = s.size();
 *     string rev(s);
 *     reverse(rev.begin(), rev.end());
 *     string s_new = s + "#" + rev;
 *     int n_new = s_new.size();
 *     vector<int> f(n_new, 0);
 *     for (int i = 1; i < n_new; i++) {
 *         int t = f[i - 1];
 *         while (t > 0 && s_new[i] != s_new[t])
 *             t = f[t - 1];
 *         if (s_new[i] == s_new[t])
 *             ++t;
 *         f[i] = t;
 *     }
 *     return rev.substr(0, n - f[n_new - 1]) + s;
 * }
 */
public class Solution214 {

    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();

        String s_new = s + "#" + rev.toString();
        int s_new_n = s_new.length();

        int[] next = new int[s_new_n];
        for(int i = 1; i < s_new_n; i++) {
            int t = next[i - 1];
            while(t > 0 && s_new.charAt(i) != s_new.charAt(t)) {
                t = next[t - 1];
            }
            if(s_new.charAt(i) == s.charAt(t)) ++t;
            next[i] = t;
        }
        return rev.substring(0, n - next[s_new_n - 1]) + s;
    }

}
