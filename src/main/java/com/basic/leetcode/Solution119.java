package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution119 {

    public static void main(String[] args) {
        Solution119 solution = new Solution119();
        System.out.println(solution.getRow2(0));
        System.out.println(solution.getRow2(1));
        System.out.println(solution.getRow2(7));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int rank = 0;
        while (rank <= rowIndex) {
            result.clear();

            for(int i = 0; i < rank + 1; i++) {
                if(i == 0 || i == rank) {
                    result.add(1);
                    continue;
                }
                result.add(temp.get(i) + temp.get(i - 1));
            }
            temp = new ArrayList<>(result);

            rank ++;
        }

        return result;
    }

    /**
     * 通项公式
     * (n-1)!/(k-1)!(n-k)!
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        rowIndex++;

        for(int i = 1; i < rowIndex + 1; i++) {
            result.add((factorial(rowIndex - 1) / factorial(i - 1) / factorial(rowIndex - i)));
        }

        return result;
    }

    private int factorial(int num) {
        if(num < 2) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

}
