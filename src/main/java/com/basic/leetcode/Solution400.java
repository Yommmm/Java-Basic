package com.basic.leetcode;

/**
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * <p>
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * <p>
 * 输出:
 * 3
 * 示例 2:
 * <p>
 * 输入:
 * 11
 * <p>
 * 输出:
 * 0
 * <p>
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution400 {

    public static void main(String[] args) {
        Solution400 solution = new Solution400();
        System.out.println(solution.findNthDigit(19));
    }

    /**
     * 1位数, 1-9, 同9 = 9 x 10^(1-1) 个数, 共 1 x 9 x 10^(1-1) 个 0-9的字符;
     * 2位数, 10-99, 同99-10+1= 90 = 9 x 10^(2-1) 数, 共 2 x 9 x 10^(2-1) 个0-9的字符;
     * 3位数, 100-999, 同999-100+1= 900 = 9 x 10^(3-1) 数, 共 3 x 9 x 10^(3-1) 个0-9的字符;
     * 4位数, 1000-9999, 同9999-1000+1= 9000 = 9 x 10^(4-1) 数, 共 4 x 9 x 10^(4-1) 个0-9的字符;
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int k = 1;
        while (k * 9 * Math.pow(10, k - 1) < n) {
            n -= k * 9 * Math.pow(10, k - 1);
            k++;
        }
        /**
         * k: 大区间
         * (n- 1) / k: 大区间所处位置
         * 1 2 3 4 5 6 7 8 9 10 11 12 13 14
         * 1 2 3 4 5 6 7 8 9 1011 1213 1415 1617 1819
         */
        int which = (n - 1) / k + (int) Math.pow(10, k - 1);
        System.out.println("which: " + which + "  n: " + n + "  k: "+ k);
        String s = String.valueOf(which);
        int r = n % k;
        if (r == 0) return s.charAt(s.length() - 1) - '0';
        return s.charAt(r - 1) - '0';
    }

    public int findNthDigit2(int n) {
        //总位数
        int sum_th = 0;
        //数字位数 一位 两位 三位
        int i = 1;
        //当前数值
        int k = 0;
        while (sum_th < n) {
            //防止溢出
            if (sum_th + i * 9 * Math.pow(10, i - 1) >= n) {
                break;
            }
            k += 9 * Math.pow(10, i - 1);
            sum_th += i * 9 * Math.pow(10, i - 1);
            i++;
        }
        //剩余数字个数
        int temp = (n - sum_th) / i;
        int mod = (n - sum_th) % i;
        k += temp;
        if (mod == 0) {
            return k % 10;
        } else {
            k++;
            return String.valueOf(k).charAt(mod - 1) - '0';
        }

    }

}
