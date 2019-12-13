package com.basic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution54 {

    public static void main(String[] args) {
        Solution54 solution = new Solution54();

        /*int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.spiralOrder(matrix));
        System.out.println("================================");
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(solution.spiralOrder(matrix2));
        System.out.println("================================");
        int[][] matrix3 = {{1, 2, 3}};
        System.out.println(solution.spiralOrder(matrix3));
        System.out.println("================================");
        int[][] matrix4 = {{1}, {2}, {3}};
        System.out.println(solution.spiralOrder(matrix4));
        System.out.println("================================");
        int[][] matrix5 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(solution.spiralOrder(matrix5));
        System.out.println("================================");
        int[][] matrix6 = {{1}};
        System.out.println(solution.spiralOrder(matrix6));
        System.out.println("================================");
        int[][] matrix7 = {{2, 5}, {8, 4}, {0, -1}};
        System.out.println(solution.spiralOrder(matrix7));
        System.out.println("================================");
        int[][] matrix8 = {{1, 2}, {6, 3}, {5, 4}};
        System.out.println(solution.spiralOrder(matrix8));
        System.out.println("================================");*/

        int[][] matrix9 = {{2, 5, 8}, {4, 0, -1}};
        System.out.println(solution.spiralOrder(matrix9));

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;

        while (t <= b && l <= r) {
            // left to right
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            // top to bottom
            for (int i = t + 1; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            if (t < b && l < r) {
                // right to left
                for (int i = r - 1; i > l; i--) {
                    result.add(matrix[b][i]);
                }
                // bottom to top
                for (int i = b; i > t; i--) {
                    result.add(matrix[i][l]);
                }
            }
            t++;
            b--;
            l++;
            r--;
        }

        return result;
    }

}
