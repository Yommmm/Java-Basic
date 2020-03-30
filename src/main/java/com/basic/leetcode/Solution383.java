package com.basic.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution383 {

    public static void main(String[] args) {
        Solution383 solution = new Solution383();
        System.out.println(solution.canConstruct("a", "b"));
        System.out.println(solution.canConstruct("aa", "ab"));
        System.out.println(solution.canConstruct("aa", "abdbdbdbdbanaabdbdbsaa"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }

        for (Integer value : map.values()) {
            if (0 < value) return false;
        }

        return true;
    }
}
