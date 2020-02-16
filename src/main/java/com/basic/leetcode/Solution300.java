package com.basic.leetcode;

/**
 * public int lengthOfLIS(int[] nums) {
 * int[] dp = new int[nums.length];
 * int len = 0;
 * for (int num : nums) {
 * int i = Arrays.binarySearch(dp, 0, len, num);
 * if (i < 0) {
 * i = -(i + 1);
 * }
 * dp[i] = num;
 * if (i == len) {
 * len++;
 * }
 * }
 * return len;
 * }
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution300 {

    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
