package com.basic.leetcode;

public class Solution50 {

    public static void main(String[] args) {
        Solution50 solution = new Solution50();
//        System.out.println(solution.myPow(-1, 1));
//        System.out.println(solution.myPow(2.00000, 10));
//        System.out.println(solution.myPow(2.10000, 3));
//        System.out.println(solution.myPow(2.00000, -2));

//        System.out.println(solution.myPow2(0.00001, 2147483647));
//        System.out.println(solution.myPow2(2, 9));
        System.out.println(solution.myPow2(2.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        if(x == 0 || x == 1) {
            return x;
        }

        int N = n;
        if(N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        for(long i = 0; i < N; i++) {
            result = result * x;
        }

        return result;
    }

    public double myPow2(double x, int n) {
        if(x == 0 || x == 1) {
            return x;
        }

        // 使用长整型，-2147483648在进行取反操作时，符号位无法改变依然是-2147483648
        long N = n;
        if(N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        double temp = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                result = result * temp;
            }
            temp = temp * temp;
        }

        return result;
    }

}
