package com.basic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Solution34 {

    public static void main(String[] args) {
        Solution34 solution = new Solution34();
        solution.searchRange1(new int[]{0, 2, 9, 3, 4, 1, 4, 5}, 4);
        solution.searchRange1(new int[]{0}, 0);
    }

    /**
     * 两边向中间扫描
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();

        int left = 0;
        int right = nums.length - 1;

        int[] result = {-1, -1};
        while (left <= right) {
            if (!map.containsKey("left")) {
                if (nums[left] == target) {
                    map.put("left", left);
                } else {
                    left++;
                }
            }

            if (!map.containsKey("right")) {
                if (nums[right] == target) {
                    map.put("right", right);
                } else {
                    right--;
                }
            }

            if (map.containsKey("left") && map.containsKey("right")) {
                result[0] = map.get("left");
                result[1] = map.get("right");
                break;
            }
        }

        result[0] = map.containsKey("left") ? map.get("left") : map.containsKey("right") ? map.get("right") : -1;
        result[1] = map.containsKey("right") ? map.get("right") : map.containsKey("left") ? map.get("left") : -1;

        System.out.println(result[0] + " " + result[1]);
        return result;
    }

    //-----------------------------------------------------------------------------------------------------------------

    public int[] searchRange1(int[] nums, int target) {
        int[] result = {-1, -1};

        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }

        if (result[0] == -1) {
            return result;
        }

        for (int j = nums.length - 1; j >= i; j--) {
            if (nums[j] == target) {
                result[1] = j;
                break;
            }
        }

        System.out.println(result[0] + " " + result[1]);
        return result;
    }

    //-----------------------------------------------------------------------------------------------------------------

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

}
