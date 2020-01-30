package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution260 {

    public static void main(String[] args) {
        Solution260 solution = new Solution260();
        System.out.println(Arrays.toString(solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        int[] result = new int[set.size()];
        int i = 0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }

        return result;
    }

}
