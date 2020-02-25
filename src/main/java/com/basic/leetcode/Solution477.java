package com.basic.leetcode;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 *
 * 输入: 4, 14, 2
 *
 * 输出: 6
 *
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 注意:
 *
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/total-hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution477 {

    public int totalHammingDistance(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int len = nums.length;
        int[] sums = new int[32];
        int x = 0;
        for (int i = 0; i < len; i++) {//统计每个二进制位上的1出现个数
            for (int j = 0; j < 32; j++) {
                sums[j] += nums[i] & 1;
                nums[i] = nums[i] >> 1;
                if (nums[i] == 0) {
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 32; i++) {//通过对每个二进制位上的1的个数和0的个数相乘，求和
            sum += sums[i] * (len - sums[i]);
        }
        return sum;
    }

}
