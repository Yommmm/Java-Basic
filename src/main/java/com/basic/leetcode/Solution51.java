package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution51 {

    public static void main(String[] args) {
        Solution51 solution = new Solution51();
        List<List<String>> lists = solution.solveNQueens(5);
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
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
        backtrace(board, 0, result, queens);
        return result;
    }

    private void backtrace(char[][] board, int x, List<List<String>> result, int[] queens) {
        if (x == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) {
                list.add(new String(row));
            }
            result.add(list);
            return;
        }

        for (int y = 0; y < board.length; y++) {
            if (validate(board, x, y, queens)) {
                board[x][y] = 'Q';
                queens[x] = y;
                backtrace(board, x + 1, result, queens);
                board[x][y] = '.';
                queens[x] = -1;
            }
        }
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
