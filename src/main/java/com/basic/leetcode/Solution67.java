package com.basic.leetcode;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution67 {

    public static void main(String[] args) {
        Solution67 solution = new Solution67();

        System.out.println(solution.addBinary("1111", "0"));
        System.out.println(solution.addBinary("1111", "1"));
        System.out.println(solution.addBinary("1111", "111"));
        System.out.println(solution.addBinary("1111", "11"));
        System.out.println(solution.addBinary("1110", "0"));
        System.out.println(solution.addBinary("1110", "1"));

        System.out.println(solution.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int up = 0;
        while (i >= 0 || j >= 0) {
            int newVal = (i < 0 ? 0 : a.charAt(i) - '0') + (j < 0 ? 0 : b.charAt(j) - '0') + up;

            up = newVal > 1 ? 1 : 0;
            sb.append(newVal % 2);

            j--;
            i--;
        }

        if (up == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

}
