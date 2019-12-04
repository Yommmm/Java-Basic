package com.basic.leetcode;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Solution48 {

    public static void main(String[] args) {
        Solution48 solution = new Solution48();
        int[][] matrix = {
                {1, 2},
                {3, 4},
        };

        int[][] matrix2 = {
                {15,13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7,10,11},
        };

        solution.rotate(matrix);
        solution.rotate(matrix2);
    }

    /**[
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     *
     * cur:[i, j]
     * next:[j, n-i]
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;

        // rank 层数
        int rank = 0;
        // 从外面到里面依层换位
        while (rank <= matrix.length >> 1) {
            for (int index = rank; index < n - rank; index++) {
                /**
                 * cur:[i, j]
                 * next:[j, n-i]
                 */
                int i = rank;
                int j = index;
                int temp = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j]; // 4号位
                matrix[n - i][n - j] = matrix[j][n - i]; // 3号位
                matrix[j][n - i] = matrix[i][j]; // 2号位
                matrix[i][j] = temp; // 1号位
            }

            rank++;
        }
    }

}
