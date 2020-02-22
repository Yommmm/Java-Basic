package com.basic.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution451 {

    public static void main(String[] args) {
        Solution451 solution = new Solution451();
        System.out.println(solution.frequencySort("raaeaedere"));
        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.frequencySort(""));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry> queue = new PriorityQueue<>((a, b) -> (int) b.getValue() - (int) a.getValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry poll = queue.poll();
            char c = (char) poll.getKey();
            int count = (int) poll.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }

        }

        return sb.toString();
    }

}
