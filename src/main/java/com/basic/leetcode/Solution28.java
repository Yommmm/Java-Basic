package com.basic.leetcode;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Solution28 {

    public static void main(String[] args) {
        Solution28 solution = new Solution28();
        System.out.println(-1 == solution.strStr("mississippi", "issipi"));
        System.out.println(-1 == solution.strStr("", "issipi"));
        System.out.println(0 == solution.strStr("mississippi", ""));
        System.out.println(0 == solution.strStr("ababa", "ab"));
        System.out.println(2 == solution.strStr("abc", "c"));
        System.out.println(0 == solution.strStr("aaaa", "a"));
        System.out.println(2 == solution.strStr("hello", "ll"));
        System.out.println(4 == solution.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
//            System.out.println("haystack.c:" + haystack.charAt(i) + " needle.c:" + needle.charAt(j));
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
            }
            if (j == needle.length()) {
//                System.out.println(i + "   " + j);
                return i - j + 1;
            }
        }

        return -1;
    }

}
