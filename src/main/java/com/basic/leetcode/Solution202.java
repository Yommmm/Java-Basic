package com.basic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution202 {

    public static void main(String[] args) {
        Solution202 solution = new Solution202();
        System.out.println(solution.isHappy(12));
        System.out.println(solution.isHappy(91));
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(28));
        System.out.println(solution.isHappy(82));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (1 != n) {
            n = next(n);
            if(set.contains(n)) return false;
            set.add(n);
        }

        return true;
    }

    private int next(int n) {
        int sum = 0;
        int num;

        while (0 != n) {
            num = n % 10;
            n /= 10;

            sum += num * num;
        }

        return sum;
    }

}
