package com.basic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution14 {

    private Node root = new Node();

    class Node {
        HashMap<Character, Node> next;

        public Node() {
            this.next = new HashMap<>();
        }
    }

    public void add(String word) {
        Node cur = root;
        add(cur, word);
    }

    /**
     * 递归添加元素
     *
     * @param cur
     * @param word
     */
    private void add(Node cur, String word) {
        if (word.length() == 0) {
            return;
        }

        char c = word.charAt(0);

        // 不判空会新增一个c节点，导致之前的c节点被覆盖为当前的c节点
        if (null == cur.next.get(c)) {
            cur.next.put(c, new Node());
        }
        add(cur.next.get(c), word.substring(1));
    }

    public String longestCommonPrefix(String[] strs) {
        int lower = Integer.MAX_VALUE;
        for(String str : strs) {
            lower = Math.min(lower, str.length());
            if("".equals(str)) {
                return str;
            }
            this.add(str);
        }

        StringBuilder sb = new StringBuilder();
        Node cur = root;
        while(cur.next.size() > 0) {
            if(cur.next.size() == 1) {
                ArrayList<Character> list = new ArrayList<>(cur.next.keySet());
                sb.append(list.get(0));
                cur = cur.next.get(list.get(0));
            } else {
                break;
            }
        }

        return sb.length() >= lower ? sb.substring(0, lower) : sb.toString();
    }

    /**
     * 这道题不应该用Trie
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        String standard = strs[0];
        for(int i = 0; i < strs.length; i++) {
//            System.out.println(standard + " " + strs[i]);
            int minlength = Math.min(standard.length(), strs[i].length());
            if(minlength == 0) {
                return "";
            }
//            System.out.println(minlength);
            for(int j = 0; j < minlength; j++) {
//                System.out.println(standard.charAt(j) + "   " + strs[i].charAt(j));
                if(standard.charAt(j) != strs[i].charAt(j)) {
                    standard = standard.substring(0, j);
                    break;
                }
                if(j == minlength - 1) {
                    standard = standard.substring(0, minlength);
                    break;
                }
            }
        }

        return standard;
    }

    public String longestCommonPrefix3(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty())
                    return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        Solution14 solution = new Solution14();

        String[] strs = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix3(strs));

        String[] strs1 = {"","b"};
        System.out.println(solution.longestCommonPrefix3(strs1));

        String[] strs2 = {"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix3(strs2));

        String[] strs3 = {"aa","a"};
        System.out.println(solution.longestCommonPrefix3(strs3));

        String[] strs4 = {"aaa","aa"};
        System.out.println(solution.longestCommonPrefix3(strs4));

        String[] strs5 = {"flower","","flight"};
        System.out.println(solution.longestCommonPrefix3(strs5));

        String[] strs6 = {""};
        System.out.println(solution.longestCommonPrefix3(strs6));

        String[] strs7 = {"flower"};
        System.out.println(solution.longestCommonPrefix3(strs7));

        String[] strs8 = {};
        System.out.println(solution.longestCommonPrefix3(strs8));
    }

    /*public static void main(String[] args) {
        Solution14 solution = new Solution14();

        String[] strs = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix2(strs));

        String[] strs1 = {"","b"};
        System.out.println(solution.longestCommonPrefix2(strs1));

        String[] strs2 = {"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix2(strs2));

        String[] strs3 = {"aa","a"};
        System.out.println(solution.longestCommonPrefix2(strs3));

        String[] strs4 = {"aaa","aa"};
        System.out.println(solution.longestCommonPrefix2(strs4));

        String[] strs5 = {"flower","","flight"};
        System.out.println(solution.longestCommonPrefix2(strs5));

        String[] strs6 = {""};
        System.out.println(solution.longestCommonPrefix2(strs6));

        String[] strs7 = {"flower"};
        System.out.println(solution.longestCommonPrefix2(strs7));

        String[] strs8 = {};
        System.out.println(solution.longestCommonPrefix2(strs8));

    }*/

    /**
     * Trie 的测试main方法
     */
    /*public static void main(String[] args) {
        Solution14 solution = new Solution14();

        String[] strs = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs));

        solution = new Solution14();
        String[] strs1 = {"","b"};
        System.out.println(solution.longestCommonPrefix(strs1));

        solution = new Solution14();
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strs2));

        solution = new Solution14();
        String[] strs3 = {"aa","a"};
        System.out.println(solution.longestCommonPrefix(strs3));

        solution = new Solution14();
        String[] strs4 = {"aaa","aa"};
        System.out.println(solution.longestCommonPrefix(strs4));

    }*/

}
