package com.basic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 上图是一个部分填充的有效的数独。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 示例 1:
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class Solution36 {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        Solution36 solution = new Solution36();
        System.out.println(solution.isValidSudoku(board));
        System.out.println(solution.isValidSudoku(board2));
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer>[] rowMaps = new HashMap[9];
        Map<Character, Integer>[] colMaps = new HashMap[9];
        Map<Character, Integer>[] boxMaps = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rowMaps[i] = new HashMap<>();
            colMaps[i] = new HashMap<>();
            boxMaps[i] = new HashMap<>();
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if ('.' != board[row][col]) {
                    // 行
                    rowMaps[row].put(board[row][col], rowMaps[row].getOrDefault(board[row][col], 0) + 1);

                    // 列
                    colMaps[col].put(board[row][col], colMaps[col].getOrDefault(board[row][col], 0) + 1);

                    // 块
                    int boxIndex = (row / 3) * 3 + col / 3;
                    boxMaps[boxIndex].put(board[row][col], boxMaps[boxIndex].getOrDefault(board[row][col], 0) + 1);

                    if (rowMaps[row].get(board[row][col]) > 1
                            || colMaps[col].get(board[row][col]) > 1
                            || boxMaps[boxIndex].get(board[row][col]) > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
