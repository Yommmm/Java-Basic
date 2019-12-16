package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution58 {

    public static void main(String[] args) {
        Solution58 solution = new Solution58();
        System.out.println(solution.lengthOfLastWord("HelloWorld"));
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord("Hello World "));
        System.out.println(solution.lengthOfLastWord("HelloWorld "));
        System.out.println(solution.lengthOfLastWord(" "));
        System.out.println(solution.lengthOfLastWord(""));
        System.out.println(solution.lengthOfLastWord(null));
        System.out.println(solution.lengthOfLastWord("a "));
        System.out.println(solution.lengthOfLastWord("     a     a a"));

    }

    public int lengthOfLastWord(String s) {
        if(null == s || s.length() == 0) {
            return 0;
        }

        int count = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            if(' ' != s.charAt(i)) {
                count ++;
            } else {
                if(count > 0) return count;
            }
        }

        return count;
    }

}