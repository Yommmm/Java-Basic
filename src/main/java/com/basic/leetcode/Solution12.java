package com.basic.leetcode;

import com.basic.datastruct.map.Map;

import java.util.HashMap;
import java.util.List;

public class Solution12 {

    public static void main(String[] args) {
        /*System.out.println(1111/1000);
        System.out.println(1111%1000);
        System.out.println();

        System.out.println(111/500);
        System.out.println(111%500);
        System.out.println();

        System.out.println(111/100);
        System.out.println(111%100);
        System.out.println();

        System.out.println(11/10);
        System.out.println(11%50);
        System.out.println();

        System.out.println(11/50);
        System.out.println(11%10);
        System.out.println();

        System.out.println(1/5);
        System.out.println(1%5);
        System.out.println();

        System.out.println(1/1);
        System.out.println(1%1);*/

        Solution12 solution = new Solution12();
        System.out.println(solution.intToRoman3(1994));

    }

    public String intToRoman(int num) {
        int[] divisors = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < divisors.length; i++) {
            int modCount = 0;
            int divisor = divisors[i];
            if((modCount = num / divisor) > 0) {
                while (modCount > 0) {
                    sb.append(romans[i]);
                    modCount --;
                }
                num = num % divisor;
            }
        }


        return sb.toString();
    }

    public String intToRoman2(int num) {
        int[] divisors = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < divisors.length; i++) {
            int modCount = 0;
            int divisor = divisors[i];
            if(num > 0 && num >= divisor && (modCount = num / divisor) > 0) {
                while (modCount > 0) {
                    sb.append(romans[i]);
                    modCount --;
                }
                num = num % divisor;
            }
        }


        return sb.toString();
    }

    public String intToRoman3(int num) {
        int[] divisors = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < divisors.length; i++) {
            int divisor = divisors[i];
            if(num >= divisor) {
                int modCount = num / divisor;
                while (modCount > 0) {
                    sb.append(romans[i]);
                    modCount --;
                }
                num = num % divisor;
            }
        }


        return sb.toString();
    }

}
