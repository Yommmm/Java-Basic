package com.basic.leetcode;

/**
 * 给定一个长度为 n 的整数数组 A 。
 * <p>
 * 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
 * <p>
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
 * <p>
 * 计算F(0), F(1), ..., F(n-1)中的最大值。
 * <p>
 * 注意:
 * 可以认为 n 的值小于 105。
 * <p>
 * 示例:
 * <p>
 * A = [4, 3, 2, 6]
 * <p>
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * <p>
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-function
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution396 {

    public static void main(String[] args) {

    }

    /**
     * 用F(k+1) - f(k)可以得到递推公式
     * F(k+1) = F(k) + sum(A) - nBk[n-1]
     *
     * @param A
     * @return
     */
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int dp1 = 0, dp2 = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            dp1 += i * A[i];
        }

        int ans = dp1;
        for (int i = 1; i < A.length; i++) {
            dp2 = dp1 + sum - A.length * A[A.length - i];
            ans = Math.max(dp2, ans);
            dp1 = dp2;
        }

        return ans;
    }

}
