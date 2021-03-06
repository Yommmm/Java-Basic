package com.basic.leetcode;

/**
 * 周赛
 * <p>
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1281 {

    public static void main(String[] args) {
        Solution1281 solution = new Solution1281();
        System.out.println(solution.subtractProductAndSum(100000));
    }

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int haha = 1;

        int standand = n;
        while (standand != 0) {
            sum = sum + (standand % 10);
            haha = haha * (standand % 10);
            standand = standand / 10;
        }

        return haha - sum;
    }

}
