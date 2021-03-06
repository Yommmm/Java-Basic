package com.basic.leetcode;

/**
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 * <p>
 * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 * <p>
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 * <p>
 * IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 * <p>
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 * <p>
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 * <p>
 * 说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "172.16.254.1"
 * <p>
 * 输出: "IPv4"
 * <p>
 * 解释: 这是一个有效的 IPv4 地址, 所以返回 "IPv4"。
 * 示例 2:
 * <p>
 * 输入: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * <p>
 * 输出: "IPv6"
 * <p>
 * 解释: 这是一个有效的 IPv6 地址, 所以返回 "IPv6"。
 * 示例 3:
 * <p>
 * 输入: "256.256.256.256"
 * <p>
 * 输出: "Neither"
 * <p>
 * 解释: 这个地址既不是 IPv4 也不是 IPv6 地址。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution468 {

    public static void main(String[] args) {
        Solution468 solution = new Solution468();
        System.out.println(solution.validIPAddress("0.0.0.0"));
        System.out.println(solution.validIPAddress("172.16.254.1"));
        System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(solution.validIPAddress("256.256.256.256"));

    }

    public String validIPAddress(String IP) {
        if (IP.startsWith(":") || IP.startsWith(".")
                || IP.endsWith(":") || IP.endsWith(".")) return "Neither";
        String[] splitted = IP.split("\\.");
        if (splitted.length == 4) {
            int num = -1;
            for (int i = 0; i < 4; i++) {
                try {
                    num = Integer.parseInt(splitted[i]);
                } catch (NumberFormatException e) {
                    return "Neither";
                }
                if (num < 0 || num > 255) return "Neither";
                if (splitted[i].length() > 1 && (splitted[i].startsWith("0") || splitted[i].startsWith("-")))
                    return "Neither";
            }
            return "IPv4";
        } else {
            splitted = IP.split(":");
            if (splitted.length == 8) {
                long num = -1;
                for (int i = 0; i < 8; i++) {
                    if (splitted[i].length() > 4 || splitted[i].startsWith("-")) return "Neither";
                    try {
                        num = Long.parseLong(splitted[i], 16);
                    } catch (NumberFormatException e) {
                        return "Neither";
                    }
                    if (num < 0) return "Neither";
                }
                return "IPv6";
            } else {
                return "Neither";
            }
        }
    }

}
