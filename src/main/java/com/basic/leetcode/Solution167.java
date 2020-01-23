package com.basic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution167 {

    public static void main(String[] args) {
        Solution167 solution = new Solution167();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        map.put(numbers[0], 1);
        for (int i = 1; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]);
                result[1] = i + 1;
                break;
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return result;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int head = 0, tail = numbers.length - 1;
        if (numbers[head] >= 0) {
            while (numbers[tail] > target) tail--;
        }
        while (head < tail) {
            int tmp = numbers[head] + numbers[tail];
            if (tmp == target) break;
            if (tmp > target) {
                tail--;
            } else {
                head++;
            }
        }
        return new int[]{head + 1, tail + 1};
    }

}
