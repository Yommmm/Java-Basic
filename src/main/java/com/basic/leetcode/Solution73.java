package com.basic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 * <p>
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution73 {

    public static void main(String[] args) {
        Solution73 solution = new Solution73();

        int[][] arr = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(arr);
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(arr[2]));
//        System.out.println(Arrays.toString(arr[3]));
    }

    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        List<Integer> rowTo0 = new ArrayList<>();
        List<Integer> cowTo0 = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (0 == matrix[i][j]) {
                    if (!rowTo0.contains(i)) rowTo0.add(i);
                    if (!cowTo0.contains(j)) cowTo0.add(j);
                }
            }
        }

        for (Integer i : rowTo0) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = 0;
            }
        }

        for (Integer j : cowTo0) {
            for (int i = 0; i < r; i++) {
                matrix[i][j] = 0;
            }
        }

    }

}
