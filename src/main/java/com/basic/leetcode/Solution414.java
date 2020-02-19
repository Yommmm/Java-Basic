package com.basic.leetcode;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution414 {

    public static void main(String[] args) {
        Solution414 solution = new Solution414();
        System.out.println(solution.thirdMax(new int[]{2, 3, 2, 1}));
        System.out.println(solution.thirdMax(new int[]{3, 2}));
        System.out.println(solution.thirdMax(new int[]{1, 2, -2147483648}));
        System.out.println(solution.thirdMax(new int[]{1, 2, 2}));
    }

    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 0; i < nums.length; ++i) {
            if (first < nums[i]) {
                third = second;
                second = first;
                first = nums[i];
            } else if (first > nums[i] && second < nums[i]) {
                third = second;
                second = nums[i];
            } else if (second > nums[i] && third < nums[i]) {
                third = nums[i];
            }
        }
        if (third == Long.MIN_VALUE) return (int)first;

        return (int)third;
    }

}
