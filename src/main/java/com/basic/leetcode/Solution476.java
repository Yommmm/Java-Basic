package com.basic.leetcode;

/**
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * <p>
 * 注意:
 * <p>
 * 给定的整数保证在32位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: 2
 * 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 * 示例 2:
 * <p>
 * 输入: 1
 * 输出: 0
 * 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution476 {

    public static void main(String[] args) {
        Solution476 solution = new Solution476();
        System.out.println(solution.findComplement(5));
    }

    public int findComplement(int num) {
        String binary = "";
        while (num > 0) {
            binary = num % 2 + binary;
            num /= 2;
        }

        int result = 0;
        for (int i = 0; i < binary.length() - 1; i++) {
            result = (result + (binary.charAt(i) == '0' ? 1 : 0)) * (binary.length() - 1 == i ? 1 : 2);
        }

        return result;
    }

    public int findComplement1(int num) {
        int tmp = num;
        int num2 = 1;
        while (tmp > 0) {
            num2 <<= 1;
            tmp >>= 1;
        }
        num2 -= 1;
        return num ^ num2;
    }

}
