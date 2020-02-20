package com.basic.leetcode;

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * <p>
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 * <p>
 * 输入:
 * 26
 * <p>
 * 输出:
 * "1a"
 * 示例 2：
 * <p>
 * 输入:
 * -1
 * <p>
 * 输出:
 * "ffffffff"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution405 {

    public static void main(String[] args) {
        Solution405 solution = new Solution405();
        System.out.println(111 & 0xf);
        System.out.println(111 >> 4);
    }

    public String toHex(int num) {
        String res = "";
        if (num == 0) {
            return "0";
        }
        String HexString = "0123456789abcdef";

        while (num != 0 && res.length() < 8) {
            res = HexString.charAt(num & 0xf) + res;
            num = num >> 4;
        }
        return res;
    }

}
