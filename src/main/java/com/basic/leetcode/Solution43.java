package com.basic.leetcode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution43 {

    public static void main(String[] args) {
        Solution43 solution = new Solution43();
        System.out.println(solution.multiply("123", "22"));
        System.out.println(solution.multiply("123", ""));
        System.out.println(solution.multiply("123", "0"));
        System.out.println(solution.multiply("0", "0"));
        System.out.println(solution.multiply("0", "123"));
    }

    public String multiply(String num1, String num2) {
        if(null == num1 || null == num2
                || 0 == num1.length() || 0 == num2.length()
                || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String result = "";

        for(int i = num2.length() - 1; i >= 0; i--) {
            String multiply = this.multiply(num1, num2.charAt(i));

            StringBuilder temp = new StringBuilder();
            temp.append(multiply);
            int j = 0;
            while (j < num2.length() - i - 1) {
                temp.append(0);
                j++;
            }
            result = addStrings(result, temp.toString());
        }

        return result;
    }

    public String multiply(String num1, char num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int n2 = num2 - '0';
        int up = 0;
        while (i >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;

            int product = n1 * n2 + up;
            result.append(product % 10);
            up = product >= 10 ? product / 10 : 0;
            i--;
        }

        if (up > 0) result.append(up);

        return result.reverse().toString();
    }

    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int up = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = n1 + n2 + up;
            result.append(sum % 10);
            up = sum >= 10 ? 1 : 0;
            i--;
            j--;
        }

        if (up == 1) result.append(1);

        return result.reverse().toString();
    }

}
