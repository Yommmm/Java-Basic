package com.basic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution290 {

    public static void main(String[] args) {
        Solution290 solution = new Solution290();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        List<String> words = Arrays.asList(str.split(" "));
        if(pattern.length() != words.size()) return false;

        Map<Character, Integer> charMap = new HashMap<>();
        int charStart = 0;
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(!charMap.containsKey(c)) charMap.put(c, ++charStart);
        }

        Map<String, Integer> wordMap = new HashMap<>();
        int wordStart = 0;
        for(int i = 0; i < pattern.length(); i++) {
            String word = words.get(i);
            if(!wordMap.containsKey(word)) wordMap.put(word, ++wordStart);
        }

        for(int i = 0; i < pattern.length(); i++) {
            if(charMap.get(pattern.charAt(i)) != wordMap.get(words.get(i))) return false;
        }

        return true;
    }

}
