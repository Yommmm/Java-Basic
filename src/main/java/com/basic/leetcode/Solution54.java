package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    public static void main(String[] args) {
        Solution54 solution = new Solution54();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.spiralOrder(matrix));
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(solution.spiralOrder(matrix2));
        int[][] matrix3 = {{1, 2, 3}};
        System.out.println(solution.spiralOrder(matrix3));
        int[][] matrix4 = {{1}, {2}, {3}};
        System.out.println(solution.spiralOrder(matrix4));
        int[][] matrix5 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(solution.spiralOrder(matrix5));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int tortal = matrix.length * matrix[0].length;

        while (result.size() < tortal) {
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l; i--) {
                result.add(matrix[b][i]);
            }
            b--;
            for (int i = b; i >= t; i--) {
                result.add(matrix[i][l]);
            }
            l++;
        }

        return result;
    }
}
