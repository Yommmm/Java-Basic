package com.basic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution56 {

    public static void main(String[] args) {
        Solution56 solution = new Solution56();

        System.out.println(Arrays.toString(solution.merge(new int[][]{
                {2, 6}, {8, 10}, {15, 18}, {1, 3}
        })));

        System.out.println(Arrays.toString(solution.merge(new int[][]{
                {1, 4}, {4, 5}
        })));

        System.out.println(Arrays.toString(solution.merge(new int[][]{
                {0, 0}, {0, 0}
        })));
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval));
        }

        // 左边界从小到大进行排序
        intervalList.sort((a, b) -> a.left - b.left);
        List<Interval> resultList = new ArrayList<>();

        for (Interval interval : intervalList) {
            /**
             * condition 1: 第一个子数组直接进入结果集
             * condition 2: 如果即将进入结果集的左边界大于结果集中最后一个的右边界
             */
            if (resultList.size() == 0 || resultList.get(resultList.size() - 1).right < interval.left) {
                resultList.add(interval);
            } else {
                // 即将进入结果集的左边界小于结果集中最后一个的右边界，取结果集中最后一个子数组右边界与即将进入的右边界的最大值
                resultList.get(resultList.size() - 1).right = Math.max(resultList.get(resultList.size() - 1).right,
                        interval.right);
            }
        }

        System.out.println(resultList);
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = new int[]{resultList.get(i).left, resultList.get(i).right};
        }

        return result;
    }

    public class Interval {
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public Interval(int[] interval) {
            this(interval[0], interval[1]);
        }

        @Override
        public String toString() {
            return "(" + left + ", " + right + ")";

        }
    }

}
