package com.basic.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Solution11 {

    public static void main(String[] args) {
        Solution11 solution = new Solution11();

        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 9};
        System.out.println(solution.maxArea2(height1));

    }

    /**
     * 复杂度：O(n²)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > 0; j--) {
                result = Math.max(result, Math.abs(i - j) * Math.min(height[i], height[j]));
            }
        }

        return result;
    }

    /**
     * 复杂度：O(n)
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int result = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            result = Math.max((right - left) * Math.min(height[right], height[left]), result);
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

}
