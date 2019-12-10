package com.basic.leetcode;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution66 {

    public static void main(String[] args) {
        Solution66 solution = new Solution66();
        int[] result = solution.plusOne(new int[]{1});
        System.out.println(Arrays.toString(result));

        result = solution.plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(result));

        result = solution.plusOne(new int[]{9, 9, 8});
        System.out.println(Arrays.toString(result));

        result = solution.plusOne(new int[]{0});
        System.out.println(Arrays.toString(result));
    }

    public int[] plusOne(int[] digits) {
        int up = 1;
        int index = digits.length - 1;
        while (index >= 0) {
            int temp = digits[index] + up;
            digits[index] = temp % 10;
            if (temp < 10) {
                up = 0;
                break;
            }

            index--;
        }

        if (up == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
