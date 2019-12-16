package com.basic.leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution64 {

    public static void main(String[] args) {
        Solution64 solution = new Solution64();

        System.out.println(solution.minPathSum(new int[][]{
                {}
        }));

        System.out.println(solution.minPathSum(new int[][]{
                {0}
        }));

        System.out.println(solution.minPathSum(new int[][]{
                {1}
        }));

        System.out.println(solution.minPathSum(new int[][]{
                {1, 1, 1}
        }));

        System.out.println(solution.minPathSum(new int[][]{
                {1},
                {1},
                {1},
        }));

        System.out.println(solution.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        }));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;

        for (int i = 1; i < c; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }

        for (int j = 1; j < r; j++) {
            grid[j][0] = grid[j - 1][0] + grid[j][0];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[r - 1][c - 1];
    }
}
