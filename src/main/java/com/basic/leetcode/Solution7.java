package com.basic.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution7 {

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        System.out.println(solution.reverse(-320));

        System.out.println();

        System.out.println(Integer.MAX_VALUE);
        System.out.println(solution.reverse(Integer.MAX_VALUE));

        System.out.println();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(solution.reverse(Integer.MIN_VALUE));

        System.out.println(solution.reverse(-2000000008));

    }

    public int reverse(int x) {
        double retValue = 0;

        while (x != 0) {
            retValue = retValue * 10 + (x % 10);
            if (Integer.MAX_VALUE < retValue || Integer.MIN_VALUE > retValue) {
                return 0;
            }
            x = x / 10;
        }


        return Double.valueOf(retValue).intValue();
    }

}
