package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Solution22 {

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        List<String> res = solution.generateParenthesis2(3);
        System.out.println(res);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个没有用掉
     * @param right  右边的括号还有几个没有用掉
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为是递归函数，所以先写递归终止条件
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 因为每一次尝试，都使用新的字符串变量，所以没有显式的回溯过程
        // 在递归终止的时候，直接把它添加到结果集即可，与「力扣」第 46 题、第 39 题区分

        // 如果左边还有剩余，继续递归下去
        if (left > 0) {
            // 拼接上一个左括号，并且剩余的左括号个数减 1
            dfs(curStr + "(", left - 1, right, res);
        }
        // 什么时候可以用右边？例如，(((((()，此时 left < right，
        // 不能用等号，因为只有先拼了左括号，才能拼上右括号
        if (right > 0 && left < right) {
            // 拼接上一个右括号，并且剩余的右括号个数减 1
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        this.rc("", n, n, result);

        return result;
    }

    private void rc(String append, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(append);
            return;
        }

        if (left > 0) {
            rc(append + "(", left - 1, right, result);
        }

        // 保证在接上最后一个右括号之前，又括号数量不超过左括号数量，保证解的正确性
        if (right > 0 && right > left) {
            rc(append + ")", left, right - 1, result);
        }
    }

}
