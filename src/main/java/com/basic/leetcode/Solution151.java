package com.basic.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 进阶：
 * <p>
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution151 {

    public static void main(String[] args) {
        Solution151 solution = new Solution151();
        System.out.println(solution.reverseWords("a good   example"));
        System.out.println(solution.reverseWords("  hello world!  "));
        System.out.println(solution.reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        List<String> words = Arrays.asList(s.split(" "));
        StringBuilder sb = new StringBuilder();

        for (int i = words.size() - 1; i >= 0; i--) {
            if (!"".equals(words.get(i))) {
                sb.append(words.get(i));
                if (i != 0) sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

}
