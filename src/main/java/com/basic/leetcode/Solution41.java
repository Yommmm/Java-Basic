package com.basic.leetcode;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution41 {

    public static void main(String[] args) {
        Solution41 solution = new Solution41();
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 3, 4, 6, 7, 8, 9}));
        System.out.println(solution.firstMissingPositive(new int[]{1, -2, 3, -4, 5, -6, 7, -8, 9}));

        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));

        System.out.println(solution.firstMissingPositive2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(solution.firstMissingPositive2(new int[]{1, 2, 3, 4, 6, 7, 8, 9}));
        System.out.println(solution.firstMissingPositive2(new int[]{1, -2, 3, -4, 5, -6, 7, -8, 9}));

        System.out.println(solution.firstMissingPositive2(new int[]{1, 2, 0}));
        System.out.println(solution.firstMissingPositive2(new int[]{3, 4, -1, 1}));
        System.out.println(solution.firstMissingPositive2(new int[]{7, 8, 9, 11, 12}));
    }

    /**
     * 检查 1 是否存在于数组中。如果没有，则已经完成，1 即为答案。
     * 如果 nums = [1]，答案即为 2 。
     * 将负数，零，和大于 n 的数替换为 1 。
     * 遍历数组。当读到数字 a 时，替换第 a 个元素的符号。
     * 注意重复元素：只能改变一次符号。由于没有下标 n ，使用下标 0 的元素保存是否存在数字 n。
     * 再次遍历数组。返回第一个正数元素的下标。
     * 如果 nums[0] > 0，则返回 n 。
     * 如果之前的步骤中没有发现 nums 中有正数元素，则返回n + 1。
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int contains = 0;

        for (int i = 0; i < length; i++) {
            if (1 == nums[i]) {
                contains++;
                break;
            }
        }

        if (0 == contains) return 1;
        if (1 == length) return 2;

        for (int i = 0; i < length; i++) {
            if (0 >= nums[i] || length < nums[i])
                nums[i] = 1;
        }

        // 数值对应下标所属元素符号转置，使用下标标识此数字已存在
        // 后续遍历中，第一个数值不为负的下标即是缺失的第一个正数
        for (int i = 0; i < length; i++) {
            int a = Math.abs(nums[i]);

            if (a == length) {
                // 循环，配合 L:79 使用
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) return i;
        }

        // 循环，配合 L:68 使用
        if (nums[0] > 0) return length;

        return length + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        // 0 不是正整数，下标从1开始标记，容量在传入数组的基础上加一
        boolean[] isExist = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length)
                continue;

            isExist[nums[i]] = true;
        }

        // 从下标1开始
        int result = 1;
        while (result <= nums.length && isExist[result]) {
            result++;
        }

        return result;
    }

}
