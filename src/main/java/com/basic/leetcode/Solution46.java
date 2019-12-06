package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution46 {

    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3, 4, 5});
        System.out.println(permute);
        System.out.println(permute.size() == 120);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        this.rc(result, new ArrayList<>(), nums);

        return result;
    }

    private void rc(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            rc(result, temp, nums);
            temp.remove(temp.size() - 1);
        }

    }

}
