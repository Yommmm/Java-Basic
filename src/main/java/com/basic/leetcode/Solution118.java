package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *        [1],
 *       [1,1],
 *      [1,2,1],
 *     [1,3,3,1],
 *    [1,4,6,4,1]
 *  [1,5,10,10,5,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution118 {

    public static void main(String[] args) {
        Solution118 solution = new Solution118();
        System.out.println(solution.generate(0));
        System.out.println(solution.generate(1));
        System.out.println(solution.generate(2));
        System.out.println(solution.generate(3));
        System.out.println(solution.generate(4));
        System.out.println(solution.generate(5));
        System.out.println(solution.generate(6));
        System.out.println(solution.generate(10));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        int rank = 1;
        while (rank <= numRows) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < rank; i++) {
                if(i == 0 || i == rank - 1) {
                    list.add(1);
                    continue;
                }
                list.add(result.get(rank - 2).get(i) + result.get(rank - 2).get(i - 1));
            }
            result.add(list);

            rank ++;
        }

        return result;
    }

}
