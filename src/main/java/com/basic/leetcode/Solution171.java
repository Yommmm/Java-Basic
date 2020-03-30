package com.basic.leetcode;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: "ZY"
 * 输出: 701
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution171 {

    public static void main(String[] args) {
        Solution171 solution = new Solution171();
        System.out.println(solution.titleToNumber("AB"));
        System.out.println(solution.titleToNumber("ZY"));
    }

    /**
     * 进制相关知识
     * 26进制
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int result = 0;

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            result = result * 26 + (c - 'A') + 1;

            i++;
        }

        return result;
    }

}
