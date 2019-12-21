package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution79 {

    public static void main(String[] args) {
        Solution79 solution = new Solution79();
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SFCSECBAS"));
    }

    // 数组长度
    int x, y;
    // 记录某个位置是否已经搜索过
    boolean[][] visted;
    // 四个方向
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        x = board.length;
        y = board[0].length;
        visted = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // 尝试从每一个点出发进行搜索，如果搜索到了就表明存在这个单词，直接返回true
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int col, String word, int index) {
        // 递归的第一步，列出终止条件，避免进入死循环。
        if (index == word.length() - 1) {
            return board[row][col] == word.charAt(index);
        }

        if (board[row][col] == word.charAt(index)) {
            visted[row][col] = true;
            // 分别从四个方向进行搜索
            for (int i = 0; i < 4; i++) {
                int nextRow = row + d[i][0];
                int nextCol = col + d[i][1];
                // 能够递归需满足位置未越界并且未被访问这样的条件
                if (legal(nextRow, nextCol) && !visted[nextRow][nextCol] && exist(board, nextRow, nextCol, word, index + 1)) {
                    return true;
                }
            }
            //搜索完以后需要回溯
            visted[row][col] = false;
        }
        return false;
    }

    // 判断位置是否越界
    private boolean legal(int row, int col) {
        return row >= 0 && row < x && col >= 0 && col < y;
    }

}
