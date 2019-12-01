package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class Solution6 {

    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        String convert = solution.convert("LEETCODEISHIRING", 4);
        System.out.println(convert.equals("LDREOEIIECIHNTSG"));

        System.out.println(solution.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if(1 == numRows) {
            return s;
        }

        List<StringBuilder> sbs = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++) {
            sbs.add(new StringBuilder());
        }

        int curRow = 0;
        int next = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sbs.get(curRow).append(c);

            if(curRow == numRows - 1) {
                next = -1;
            }
            if(curRow == 0) {
                next = 1;
            }
            curRow = curRow + next;
        }

        StringBuilder sb = sbs.get(0);
        for(int i = 1; i < sbs.size(); i++) {
            sb.append(sbs.get(i));
        }

        return sb.toString();
    }

}
