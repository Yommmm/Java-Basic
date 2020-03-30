package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution52 {

    public static void main(String[] args) {
        Solution52 solution = new Solution52();
        Solution51 solution51 = new Solution51();

        System.out.println();
        int i = 0;
        while (i < 100) {
            int ceil = (int) Math.ceil(Math.random() * 100);
            System.out.println(solution51.solveNQueens(ceil).size() == solution.totalNQueens(ceil));
            i++;
        }

    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        int[] queens = new int[n];
        for (int i = 0; i < n; i++) {
            queens[i] = -1;
        }

        return backtrace(board, 0, 0, queens);
    }

    private int backtrace(char[][] board, int x, int count, int[] queens) {
        for (int y = 0; y < board.length; y++) {
            if (validate(board, x, y, queens)) {
                board[x][y] = 'Q';
                queens[x] = y;
                if (x + 1 == board.length) {
                    count++;
                } else {
                    count = backtrace(board, x + 1, count, queens);
                }
                board[x][y] = '.';
                queens[x] = -1;
            }
        }

        return count;
    }

    private boolean validate(char[][] board, int x, int y, int[] queens) {
        if (y == board.length) return false;

        int dx, dy;
        for (int qx = 0; qx < x; qx++) {
            dy = y - queens[qx];
            if (dy == 0) return false;

            dx = x - qx;
            if (dx == dy || dx == -dy) return false;
        }

        return true;
    }
}
