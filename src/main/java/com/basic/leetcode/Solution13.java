package com.basic.leetcode;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution13 {

    public static void main(String[] args) {
        Solution13 solution = new Solution13();
        System.out.println(solution.romanToInt3("III"));
        System.out.println(solution.romanToInt3("IV"));
        System.out.println(solution.romanToInt3("IX"));
        System.out.println(solution.romanToInt3("LVIII"));
        System.out.println(solution.romanToInt3("MCMXCIV"));

    }

    /**
     * 字符串截取比对取值相加，超时
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int index = 0;
        int ret = 0;
        while (s.length() > 0 && index < romans.length) {
            if (s.indexOf(romans[index]) == 0) {
                ret += nums[index];
                s = s.substring(romans[index].length());
            }
            if (!"I".equals(romans[index])) {
                index++;
            }
        }

        return ret;
    }

    /**
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        int sum = 0;

        int index = 0;
        while (index < s.length()) {
            int firstValue = getValue(s.charAt(index));
            int secondValue = (index + 1) >= s.length() ? 0 : getValue(s.charAt(index + 1));

            if (firstValue - secondValue >= 0) {
                sum += firstValue;
                index++;
            } else {
                sum += (secondValue - firstValue);
                index += 2;
            }
        }

        return sum;
    }

    /**
     * 对于处理有边界的数据：使用前驱数据比使用后继数据要方便
     *
     * @param s
     * @return
     */
    public int romanToInt3(String s) {
        int sum = 0;

        int prenum = getValue(s.charAt(0));
        for (int index = 1; index < s.length(); index++) {
            int curnum = getValue(s.charAt(index));

//            System.out.println(s.charAt(index));
//            System.out.println("prenum:" + prenum + " curnum:" + curnum);
            if (prenum < curnum) {
                sum -= prenum;
            } else {
                sum += prenum;
            }

            prenum = curnum;
        }

        return sum + prenum;
    }

    public int getValue(char key) {
        switch (key) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}
