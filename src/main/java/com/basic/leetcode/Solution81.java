package com.basic.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution81 {

    public static void main(String[] args) {
        Solution81 solution = new Solution81();

        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{1, 3, 1, 1, 1}, 3));
        System.out.println(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{1, 3}, 3));
        System.out.println(solution.search(new int[]{1, 1, 1, 1, 1, 1, 0, 1, 1, 1}, 0));

    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            // 问题细化
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // 如果一直等于中间值，从左至右遍历整个数组
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }

            if (nums[left] < nums[mid]) {
                // 继续问题细化
                if (nums[left] <= target && target < nums[mid]) {
                    // 从左边范围寻找
                    right = mid - 1;
                } else {
                    // 从右边范围寻找
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    // 从左边范围寻找
                    left = mid + 1;
                } else {
                    // 从右边范围寻找
                    right = mid - 1;
                }
            }

        }

        return false;
    }

}
