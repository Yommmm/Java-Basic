package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution205 {

    public static void main(String[] args) {
        Solution205 solution = new Solution205();
        System.out.println(solution.isIsomorphic("add", "bcc"));
    }

    public boolean isIsomorphic(String s, String t) {
//        return is(s, t) && is(t, s);
        return is(s).equals(is(t));
    }

    private boolean is(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (c2 != map.get(c1)) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }

        return true;
    }

    private String is(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当前字母第一次出现,赋值
            if (map[c] == 0) {
                map[c] = count;
                count++;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }

}
