package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

import java.util.*;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution438 {

    public static void main(String[] args) {
        Solution438 solution = new Solution438();
        System.out.println(solution.findAnagrams("abcabc", "abc"));
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        char[] a = p.toCharArray();
        Arrays.sort(a);

        int i = 0;
        for (int j = p.length(); j <= s.length(); j++) {
            char[] b = s.substring(i, j).toCharArray();
            if (eq(a, b)) result.add(i);
            i++;
        }

        return result;
    }

    private boolean eq(char[] a, char[] b) {
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLength = s.length(), pLength = p.length();
        if (sLength < pLength)
            return res;
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

        int[] numOfC = new int[52];
        for (int i = 0; i < pLength; i++) {
            numOfC[sc[i] - 'a']++;
            numOfC[pc[i] - 'a']--;
        }

        for (int lastIndexOfList = pLength - 1; lastIndexOfList < sLength; lastIndexOfList++) {
            if (lastIndexOfList != pLength - 1) {
                numOfC[sc[lastIndexOfList] - 'a']++;
                numOfC[sc[lastIndexOfList - pLength] - 'a']--;
            }

            int flag = 0;
            for (int x : numOfC) {
                if (x != 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                res.add(lastIndexOfList - pLength + 1);
        }

        return res;
    }

}
