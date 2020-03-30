package com.basic.leetcode;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution84 {

    public static void main(String[] args) {
        Solution84 solution = new Solution84();

        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int area = 0;

        for (int i = 0; i < heights.length; i++) {
            /**
             * ①保证栈中数据出栈从大到小有序
             * ②即将入栈元素比栈顶元素小时，计算栈中最大区域
             */
            while (-1 != stack.peek() && heights[stack.peek()] >= heights[i]) {
                area = Math.max(area, heights[stack.pop()] * (i - stack.peek() - 1));
            }

            stack.push(i);
        }

        while (-1 != stack.peek()) {
            area = Math.max(area, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return area;
    }

}
