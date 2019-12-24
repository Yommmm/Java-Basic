package com.basic.leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution91 {

    public static void main(String[] args) {
        Solution91 solution = new Solution91();

        System.out.println(solution.numDecodings("2266554998444151574151"));
    }

    /**
     * 动态规划
     * 动态转移方程：dp[i] = dp[i+1] + dp[i+2]
     * 条件：两数之和不超过26
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int result = chars[length - 1] == '0' ? 0 : 1;

        // 上一个值 也就是 i+1 也可以理解为 next
        int pre = 1;

        for (int i = length - 2; i >= 0; i--) {
            if (chars[i] == '0') {
                pre = result;
                result = 0;
                continue;
            }

            // 按照 dp[i]+dp[i+1]<=26 逻辑向前推
            if ((chars[i] - '0') * 10 + (chars[i + 1] - '0') <= 26) {
                int temp = result;
                result = result + pre;
                pre = temp;
            } else {
                pre = result;
            }
        }

        return result;
    }

}
