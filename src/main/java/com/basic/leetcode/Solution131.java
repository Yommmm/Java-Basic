package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution131 {

    public static void main(String[] args) {
        String a = "aaabbb";
        Solution131 solution = new Solution131();
        System.out.println(solution.partition(a));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, s, new ArrayList<>());
        return result;
    }

    /**
     * @param result
     * @param s
     * @param tmp
     */
    private void backtrack(List<List<String>> result, String s, List<String> tmp) {
        if (s == null || s.length() == 0) {
            result.add(new ArrayList<>(tmp));
        }

        for (int i = 1; i <= s.length(); i++) {
            if (isPalidrome(s.substring(0, i))) {
                tmp.add(s.substring(0, i));
                backtrack(result, s.substring(i), tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    /**
     * 判断是否为回文串：中心扩展法
     *
     * @param target
     * @return
     */
    private boolean isPalidrome(String target) {
        int left = 0;
        int right = target.length() - 1;
        while (left < right) {
            if (target.charAt(left) != target.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

}