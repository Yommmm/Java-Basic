package com.basic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5303. 解码字母到整数映射  显示英文描述
 * 用户通过次数 4
 * 用户尝试次数 5
 * 通过次数 4
 * 提交次数 5
 * 题目难度 Easy
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 *
 * 输入：s = "1326#"
 * 输出："acz"
 * 示例 3：
 *
 * 输入：s = "25#"
 * 输出："y"
 * 示例 4：
 *
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * s 是映射始终存在的有效字符串。
 */
public class Solution5303 {

    public static void main(String[] args) {
        Solution5303 solution = new Solution5303();

        System.out.println(solution.freqAlphabets(""));
        System.out.println(solution.freqAlphabets("10#11#12"));
        System.out.println(solution.freqAlphabets("1326#"));
        System.out.println(solution.freqAlphabets("25#"));
        System.out.println(solution.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

    public String freqAlphabets(String s) {
        Map<String, Character> map = new HashMap<>();

        char a = 'a';
        for(int i = 0; i < 26; i++) {
            char temp = (char) ('a' + i);

            map.put(String.valueOf(i + 1), temp);
        }

        StringBuilder result = new StringBuilder();
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i + 2 < s.length() && '#' == s.charAt(i + 2) && map.containsKey(s.substring(start, i + 2))) {
                result.append(map.get(s.substring(start, i + 2)));
                i += 2;
            } else {
                result.append(map.get(s.substring(start, i + 1)));
            }
            start = i + 1;
        }

        return result.toString();
    }

    public String freqAlphabets1(String s) {
        StringBuilder result = new StringBuilder();

        List<String> strings = Arrays.asList(s.split("#"));
        for(String str : strings) {
            Integer temp = Integer.valueOf(str);
            if(temp < 27) {
                result.append((char)(temp + 'a'));
            } else {
                for(int i = 0; i < str.length(); i++) {
                    result.append((char)(temp + 'a'));
                }
            }
        }

        return result.toString();
    }

}
