package com.basic.leetcode;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumArray {

    /**
     * 暴力破解
     */
    /*private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for(int k = i; k <= j; k++) sum += nums[k];

        return sum;
    }*/

    /**
     * dp
     * sumRange(i, j) = sum[j + 1] - sum[i]
     */
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    /**
     * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
     *
     * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
     *
     * 示例:
     *
     * Given nums = [1, 3, 5]
     *
     * sumRange(0, 2) -> 9
     * update(1, 2)
     * sumRange(0, 2) -> 8
     * 说明:
     *
     * 数组仅可以在 update 函数下进行修改。
     * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void update(int i, int val) {

    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
