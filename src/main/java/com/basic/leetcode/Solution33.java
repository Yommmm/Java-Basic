package com.basic.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Solution33 {

    public static void main(String[] args) {
        Solution33 solution = new Solution33();
        System.out.println(solution.search(new int[]{}, 0));
        System.out.println(solution.search(new int[]{0}, 0));
        System.out.println(solution.search(new int[]{0 , 0}, 0));
        System.out.println(solution.search(new int[]{0, 1, 2, 3}, 2));
        System.out.println(solution.search(new int[]{4, 5, 6, 0, 1, 2, 3}, 3));
    }

    /**
     * 4 5 6 7 0 1 2
     * 6 7 0 1 2 4 5
     * 问题不断细化
     * 旨在能在有序的数据段内找出目标值
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {  //左边升序
                if (target >= nums[left] && target <= nums[mid]) {
                    // 在左边升序范围内查找
                    right = mid - 1;
                } else {
                    // 从右边找
                    left = mid + 1;
                }

            } else { //右边升序
                if (target >= nums[mid] && target <= nums[right]) {
                    // 在右边升序范围内查找
                    left = mid + 1;
                } else {
                    // 从左边找
                    right = mid - 1;
                }

            }
            mid = left + (right - left) / 2;
        }

        return -1;  //没找到
    }

    /**
     * 解题思路：
     * 1.寻找左右哪边有序
     * 2.判断有序数据段是否满足查询条件
     *      Y：直接二分查找
     *      N：重复【1】【2】步骤直到问题细化到【Y】
     * 可理解为把有序的数据段全部排除掉，最后留下的就是解
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;

        while(left <= right) {
            if (nums[mid] == target) {
                return mid;
            }

            if(nums[left] <= nums[mid]) {
                // 继续问题细化
                if(nums[left] <= target && target < nums[mid]) {
                    // 从左边范围寻找
                    right = mid - 1;
                } else {
                    // 从右边范围寻找
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]) {
                    // 从左边范围寻找
                    left = mid + 1;
                } else {
                    // 从右边范围寻找
                    right = mid - 1;
                }
            }

            // 问题细化
            mid = mid = left + (right - left) / 2;
        }

        return -1;
    }

}
