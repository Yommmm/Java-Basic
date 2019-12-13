package com.basic.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的【最大长度！！！而不是固定长度！！！】。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution55 {

    public static void main(String[] args) {
        Solution55 solution = new Solution55();
        System.out.println(solution.canJump2(new int[]{1, 2, 3, 4, 5, 6})); // true
        System.out.println(solution.canJump2(new int[]{2, 3, 1, 1, 4})); // ture
        System.out.println(solution.canJump2(new int[]{3, 2, 1, 0, 4})); // false
        System.out.println(solution.canJump2(new int[]{0, 2, 1, 0, 4})); // false
        System.out.println(solution.canJump2(new int[]{2, 1, 1, 1, 1, 1, 1})); // true
        System.out.println(solution.canJump2(new int[]{2, 1})); // true
        System.out.println(solution.canJump2(new int[]{2, 1, 1})); // true
        System.out.println(solution.canJump2(new int[]{1})); // true
        System.out.println(solution.canJump2(new int[]{2})); // true
        System.out.println(solution.canJump2(new int[]{2, 5, 0, 0})); // false
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public boolean canJump3(int[] nums) {
        int start = 0;
        int end = 0;
        while (start <= end && end < nums.length - 1) {
            end = Math.max(end, nums[start] + start);
            start++;
        }
        return end >= nums.length - 1;
    }


}
