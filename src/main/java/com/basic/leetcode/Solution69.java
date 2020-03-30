package com.basic.leetcode;

public class Solution69 {

    public static void main(String[] args) {
        Solution69 solution = new Solution69();
        System.out.println(solution.mySqrt(0));
        System.out.println(solution.mySqrt(1));
        System.out.println(solution.mySqrt(9));
        System.out.println(solution.mySqrt(16));
        System.out.println(solution.mySqrt(15));
        System.out.println(solution.mySqrt(13));
        System.out.println(solution.mySqrt(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        long left = 1;
        long right = x >>> 1;

        while (left < right) {
            long mid = (left + right + 1) >>> 1;

            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (int) left;
    }

}
