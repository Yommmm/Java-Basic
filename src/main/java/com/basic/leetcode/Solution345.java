package com.basic.leetcode;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution345 {

    public static void main(String[] args) {
        Solution345 solution = new Solution345();
        System.out.println(solution.reverseVowels("hello"));
        System.out.println(solution.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!is(chars[left])) {
                left++;
                continue;
            }
            if (!is(chars[right])) {
                right--;
                continue;
            }
            swap(chars, left, right);
            left++;
            right--;
        }

        return String.valueOf(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

    private boolean is(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
