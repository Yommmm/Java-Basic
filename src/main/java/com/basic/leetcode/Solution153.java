package com.basic.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution153 {

    public static void main(String[] args) {

    }

    public int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            result = Math.min(result, num);
        }

        return result;
    }

    public int findMin1(int[] nums) {
        // 情况1，一个元素
        if (nums.length == 1) {
            return nums[0];
        }

        // 情况2，未旋转
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        // 情况3，旋转
        while (right >= left) {
            int mid = (left + right) / 2;

            // 找到旋转点的特判
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // 没找到旋转点，进行迭代
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
