package com.basic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
//        System.out.println(solution.lengthOfLongestSubstring(""));
//        System.out.println(solution.lengthOfLongestSubstring("aaaaaa"));
//        System.out.println(solution.lengthOfLongestSubstring("abcaaa"));
//        System.out.println(solution.lengthOfLongestSubstring("abcadf"));
//        System.out.println(solution.lengthOfLongestSubstring("qwerty"));
//        System.out.println(solution.lengthOfLongestSubstring("asdfas"));
        System.out.println(solution.lengthOfLongestSubstring("asdsad"));
    }

    /**
     * 1.对于第一次进入窗口的字符，缓存 +1
     * 2.对于第二次进入窗口的字符，计算当前窗口长度，更新比较起始元素下标，取最值
     * 3.一直到字符串最后一个字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        HashMap<Character, Integer> map = new HashMap<>();

        // 最大字符串长度
        int longest = 0;

        // 窗口起始下标
        int startIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 如果当前下标存在，窗口初始下标右移
                /**
                 * 必须做比较！
                 * 【asdasd】对于这类重复数据，
                 * startIndex 如果不判断直接获取前一个元素
                 * 走到第 2 个 a 时，startIndex会从 s-2 飘到 a-1
                 * 增加数据长度，针对【abba】数据定制
                 */
                startIndex = Math.max(map.get(c), startIndex);
            }
            // 比较当前最大长度与窗口长度
            longest = Math.max(longest, i - startIndex + 1);

            // 窗口中下标位置后移 1 位
            map.put(c, i + 1);
        }

        return longest;
    }

    /**
     * qwertyui
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        // 初始换窗口、长度
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();

        // 最长字符串长度、窗口长度
        int longest = 0;
        int temp = 0;

        for (int index = 0; index < len; index++) {
            // 获取字符
            char c = s.charAt(index);

            // 如果窗口中包含字符 c ，获取 c 的值
            if (map.containsKey(c)) {
                temp = Math.max(map.get(c), temp);
            }
            longest = Math.max(longest, index - temp + 1);
            map.put(c, index + 1);
        }
        return longest;
    }

}