package com.basic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution57 {

    public static void main(String[] args) {
        Solution57 solution = new Solution57();
        int[][] insert = solution.insert(null, null);
        System.out.println(Arrays.toString(insert[0]));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        int[][] newIntervals = new int[length + 1][];
        System.arraycopy(intervals, 0,newIntervals, 0, length);
        newIntervals[length] = newInterval;

        return merge(newIntervals);
    }

    private int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval));
        }

        intervalList.sort((a, b) -> a.left - b.left);
        List<Interval> resultList = new ArrayList<>();

        for (Interval interval : intervalList) {
            if (resultList.size() == 0 || resultList.get(resultList.size() - 1).right < interval.left) {
                resultList.add(interval);
            } else {
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
