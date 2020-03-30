package com.basic.leetcode;


import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 九宫格输入界面
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution17 {

    public static void main(String[] args) {
        Solution17 solution = new Solution17();
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("1"));
        System.out.println(solution.letterCombinations("12"));
        System.out.println(solution.letterCombinations("122"));
        System.out.println(solution.letterCombinations("123"));
        System.out.println(solution.letterCombinations("2"));
        System.out.println(solution.letterCombinations("21"));
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("234"));
        System.out.println(solution.letterCombinations("2347"));
    }

    /**
     * 可使用回溯法
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, List<String>> map = this.getMap();

        List<String> standard = map.containsKey(digits.charAt(0)) ? map.get(digits.charAt(0)) : new ArrayList<>();

        for (int i = 1; i < digits.length(); i++) {

            if (map.containsKey(digits.charAt(i))) {
                List<String> compare = map.get(digits.charAt(i));
                List<String> temp = new ArrayList<>();
                if (standard.size() == 0) {
                    standard = compare;
                    continue;
                }

                for (int j = 0; j < standard.size(); j++) {
                    for (int k = 0; k < compare.size(); k++) {
                        temp.add(standard.get(j) + compare.get(k));
                    }
                }

                standard = temp;
            }
        }

        System.out.println(standard.size());
        return standard;
    }

    public Map<Character, List<String>> getMap() {
        Map<Character, List<String>> map = new HashMap<>();

        map.put('2', new ArrayList<>(Arrays.asList(new String[]{"a", "b", "c"})));
        map.put('3', new ArrayList<>(Arrays.asList(new String[]{"d", "e", "f"})));
        map.put('4', new ArrayList<>(Arrays.asList(new String[]{"g", "h", "i"})));
        map.put('5', new ArrayList<>(Arrays.asList(new String[]{"j", "k", "l"})));
        map.put('6', new ArrayList<>(Arrays.asList(new String[]{"m", "n", "o"})));
        map.put('7', new ArrayList<>(Arrays.asList(new String[]{"p", "q", "r", "s"})));
        map.put('8', new ArrayList<>(Arrays.asList(new String[]{"t", "u", "v"})));
        map.put('9', new ArrayList<>(Arrays.asList(new String[]{"w", "x", "y", "z"})));

        return map;
    }

    // -------------------------------------------------递归写法---------------------------------------------------------


    // -------------------------------------------------回溯法-----------------------------------------------------------

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    /**
     * 回溯法
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

}
