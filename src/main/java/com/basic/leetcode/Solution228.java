package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 * <p>
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution228 {

    public static void main(String[] args) {
        Solution228 solution = new Solution228();
        System.out.println(solution.summaryRanges(new int[]{1, 2, 3, 5, 6, 7, 9, 10, 11, 14, 15, 16, 18}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int start = 0, end = 0; end < nums.length; ++end) {
            if (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) continue;

            if (start == end) summary.add(nums[start] + "");
            else summary.add(nums[start] + "->" + nums[end]);

            start = end + 1;
        }
        return summary;
    }

}
