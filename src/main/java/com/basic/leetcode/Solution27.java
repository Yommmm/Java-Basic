package com.basic.leetcode;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution27 {

    public static void main(String[] args) {
        Solution27 solution = new Solution27();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(solution.removeElement(nums, 2));
    }

    public int removeElement(int[] nums, int val) {
        // 赋值指针
        int index = 0;

        // 扫描指针
        for (int i = 0; i < nums.length; i++) {
            // 扫描到不匹配的值，使用赋值指针进行赋值；
            // 扫描到匹配值，赋值指针跳过新增
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

}
