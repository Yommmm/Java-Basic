package com.basic.leetcode;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution347 {

    public static void main(String[] args) {
        Solution347 solution = new Solution347();
        System.out.println(solution.topKFrequent2(new int[]{1, 1, 1, 3, 3, 3, 4, 4, 4, 2, 2}, 2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) heap.poll();
        }

        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

        Collections.reverse(result);
        return result;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(entries);
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }

        return result;
    }

}
