package com.basic.leetcode;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution198 {

    public static void main(String[] args) {
        Solution198 solution = new Solution198();
        System.out.println(solution.rob(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    /**
     * 动态规划
     * 动态方程：dp[i] = Max(dp[i - 1], dp[i - 2] + nums[i - 1])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) return 0;

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[dp.length - 1];
    }

    public int rob2(int[] nums) {
        int cur = 0;
        int prev = 0;

        for (int num : nums) {
            int temp = cur;
            cur = Math.max(prev + num, cur);
            prev = temp;
        }

        return cur;
    }

}
