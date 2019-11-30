package com.basic.leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.lengthOfLongestSubstring("aaaaaa"));
        System.out.println(solution.lengthOfLongestSubstring("abcaaa"));
        System.out.println(solution.lengthOfLongestSubstring("aaaaaa"));
        System.out.println(solution.lengthOfLongestSubstring("aaaaaa"));
        System.out.println(solution.lengthOfLongestSubstring("aaaaaa"));
        System.out.println(solution.lengthOfLongestSubstring("aaaaaa"));
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Character> map = new HashMap<>();

        int longest = 0;
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), s.charAt(i));
                longest ++;
            } else {
                map.clear();
                map.put(s.charAt(i), s.charAt(i));
                longest = 1;
            }
        }

        return longest;
    }

}
