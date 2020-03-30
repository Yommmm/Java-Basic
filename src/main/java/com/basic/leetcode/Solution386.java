package com.basic.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * <p>
 * 例如，
 * <p>
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution386 {

    public static void main(String[] args) {
        Solution386 solution = new Solution386();
        System.out.println(solution.lexicalOrder(1));
    }

    public List<Integer> lexicalOrder(int n) {
        return Stream.iterate(1, item -> item + 1).limit(n).sorted(Comparator.comparing(String::valueOf)).collect(Collectors.toList());
    }

}
