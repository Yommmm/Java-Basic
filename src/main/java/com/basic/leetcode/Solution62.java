package com.basic.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution62 {

    public static void main(String[] args) {
        Solution62 solution = new Solution62();

        System.out.println(solution.uniquePaths(3, 3));
    }

    /**
     * 解题思路：动态规划，问题细化
     * 我们令 dp[i][j] 是到达 i, j 最多路径
     * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
     * 时间复杂度：O(m*n)O(m∗n)
     * <p>
     * 空间复杂度：O(m * n)O(m∗n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];

        for (int i = 0; i < n; i++) map[0][i] = 1;
        for (int j = 0; j < m; j++) map[j][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }

        return map[m - 1][n - 1];
    }

}
