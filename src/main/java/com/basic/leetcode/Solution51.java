package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution51 {

    public static void main(String[] args) {
        Solution51 solution = new Solution51();

        List<String> temp = new ArrayList<>();
        temp.add(".Q..");
        temp.add("...Q");
        temp.add("Q...");

        System.out.println(solution.isValidate(temp, "..Q.", 3));
        System.out.println(solution.isValidate(temp, "...Q", 3));
        System.out.println(solution.isValidate(temp, ".Q..", 3));
        System.out.println(solution.isValidate(temp, "Q...", 3));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        return result;
    }

    private void rc(int n, int rank, String str, List<List<String>> result, List<String> temp) {
        // 递归终止条件
        if(isValidate(temp, str, n)) {
            temp.add(str);
        } else {
            return;
        }

        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
//            sb.insert();
            rc(n, i, sb.toString(), result, temp);
        }
    }

    private boolean isValidate(List<String> result, String insert, int i) {
        int q = insert.indexOf("Q");

        for(int j = 0; j < result.size(); j++) {
            int rq = result.get(j).indexOf("Q");

            /**
             * x1 == x2;
             * y1 == y2;
             * Math.abs((y1 - y2) / (x1 - x2)) == 1;
             */
            if(rq == q || i == j || Math.abs((rq - q) / (i - j)) == 1) {
                return false;
            }
        }

        return true;
    }

}
