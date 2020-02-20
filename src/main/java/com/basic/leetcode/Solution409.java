package com.basic.leetcode;

/**
 *
 */
public class Solution409 {

    public static void main(String[] args) {

    }

    public int longestPalindrome(String s) {
        int[] count = new int[128];

        for (char c : s.toCharArray()) count[c]++;

        int result = 0;
        for (int i : count) {
            result += i / 2 * 2;
            if (i % 2 == 1 && result % 2 == 0) result += 1;
        }

        return result;
    }

}
