package com.basic.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution93 {

    public static void main(String[] args) {
        Solution93 solution = new Solution93();
//        List<String> strings = solution.restoreIpAddresses("25525511135");
//        System.out.println(strings);

        List<String> strings = solution.restoreIpAddresses("12034");
        System.out.println(strings);
    }


    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        restoreIpAddresses(0, "", 4, s, result, n);
        return result;
    }

    private void restoreIpAddresses(int i, String tmp, int rank, String s, List<String> result, int n) {
        if (rank < 0) return;

        if (i == n && rank == 0) {
            result.add(tmp.substring(0, tmp.length() - 1));
            return;
        }


        for (int j = i; j < i + 3 && j < n; j++) {
            if (i == j && s.charAt(j) == '0') {
                restoreIpAddresses(j + 1, tmp + s.charAt(j) + ".", rank - 1, s, result, n);
                break;
            }

            if (Integer.valueOf(s.substring(i, j + 1)) <= 255) {
                restoreIpAddresses(j + 1, tmp + s.substring(i, j + 1) + ".", rank - 1, s, result, n);
            }
        }
    }

}
