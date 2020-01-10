package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution215 {

    public static void main(String[] args) {
        Solution215 solution = new Solution215();
        System.out.println(solution.findKthLargest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);

        for (int num : nums) {
            heap.add(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }

}
