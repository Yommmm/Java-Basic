package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution46 {

    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3, 4});
        System.out.println(permute);
        System.out.println(permute.size());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                for (int k = 0; k < nums.length; k++) {
                    if (k == j || k == i) {
                        continue;
                    } else {
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        result.add(integers);
                    }
                }
            }
        }

        return result;
    }

}
