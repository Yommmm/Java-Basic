package com.basic.leetcode;


public class Solution443 {

    public static void main(String[] args) {
        Solution443 solution = new Solution443();
        System.out.println();

    }

    public int compress(char[] chars) {
        int fast = 0;
        int low = 0;

        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == chars.length || chars[i + 1] != chars[i]) {
                chars[low++] = chars[fast];
                if (i > fast) {
                    for (char c : ("" + (i - fast + 1)).toCharArray()) {
                        chars[low++] = c;
                    }
                }
                fast = i + 1;
            }
        }
        return low;
    }

}
