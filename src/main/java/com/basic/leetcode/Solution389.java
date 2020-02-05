package com.basic.leetcode;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution389 {

    public static void main(String[] args) {
        Solution389 solution = new Solution389();
        System.out.println(solution.findTheDifference("abcd", "dbeac"));
    }

    public char findTheDifference(String s, String t) {
        char a = 0;
        for(int i = 0; i < s.length(); i++) {
            a ^= s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++) {
            a ^= t.charAt(i);
        }

        return a;
    }

}
