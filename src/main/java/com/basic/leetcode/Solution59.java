package com.basic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution59 {

    public static void main(String[] args) {
        Solution59 solution = new Solution59();

        int[][] result = solution.generateMatrix(9);
        for (int i = 0; i < result.length; i ++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int num = 1;
        int target = n * n;

        int l = 0, r = n - 1, t = 0, b = n - 1;

        while (num <= target) {
            for(int i = l; i <= r; i++) {
                result[t][i] = num++;
            }
            t++;
            for(int i = t; i <= b; i++) {
                result[i][r] = num++;
            }
            r--;
            for(int i = r; i >= l; i--){
                result[b][i] = num++;
            }
            b--;
            for(int i = b; i >= t; i--){
                result[i][l] = num++;
            }
            l++;
        }

        return result;
    }

}
