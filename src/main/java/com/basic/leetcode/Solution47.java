package com.basic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution47 {

    public static void main(String[] args) {
        Solution47 solution = new Solution47();
        List<List<Integer>> permute = solution.permuteUnique(new int[]{1, 1, 2});
        System.out.println(permute);
        System.out.println(permute.size() == 120);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        this.rc(result, new ArrayList<>(), nums, new ArrayList<>());

        return result;
    }

    private void rc(List<List<Integer>> result, List<Integer> temp, int[] nums, List<Integer> indexTemp) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(indexTemp.contains(i)) {
                continue;
            }
            temp.add(nums[i]);
            indexTemp.add(i);
            rc(result, temp, nums, indexTemp);
            temp.remove(temp.size() - 1);
            indexTemp.remove(indexTemp.size() - 1);
        }

    }

}
