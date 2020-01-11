package com.basic.leetcode;

import java.util.Arrays;

/**
 * 5144. 矩阵区域和  显示英文描述
 * 用户通过次数 334
 * 用户尝试次数 366
 * 通过次数 340
 * 提交次数 444
 * 题目难度 Medium
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 * <p>
 * i - K <= r <= i + K, j - K <= c <= j + K
 * (r, c) 在矩阵内。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 */
public class Solution5144 {

    public static void main(String[] args) {
        Solution5144 solution = new Solution5144();
//        int[][] ints = solution.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3);

        int[][] ints = solution.matrixBlockSum(new int[][]{{67, 64, 78}, {99, 98, 38}, {82, 46, 46}, {6, 52, 55}, {55, 99, 45}}, 3);

        System.out.println(Arrays.toString(ints[0]));
        System.out.println(Arrays.toString(ints[1]));
        System.out.println(Arrays.toString(ints[2]));
        System.out.println(Arrays.toString(ints[3]));
        System.out.println(Arrays.toString(ints[4]));
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] result = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int rs = i - K > 0 ? i - K : 0;
                int re = i + K < row ? i + K : row - 1;

                int cs = j - K > 0 ? j - K : 0;
                int ce = j + K < col ? j + K : col - 1;

                result[i][j] = this.sum(mat, rs, re, cs, ce);
            }
        }

        return result;
    }

    private int sum(int[][] mat, int rs, int re, int cs, int ce) {
        int sum = 0;

        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {
                sum += mat[i][j];
            }
        }

        return sum;
    }

}
