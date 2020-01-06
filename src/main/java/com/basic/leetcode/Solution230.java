package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution230 {

    public static void main(String[] args) {
        Solution230 solution = new Solution230();
        System.out.println(solution.kthSmallest(TreeNode.convert(new Integer[]{3, 1, 4, null, 2}), 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        this.inOrder(root, result, k);
        return result.get(k - 1);
    }

    private void inOrder(TreeNode node, List<Integer> list, int k) {
        if(null == node) return;

        inOrder(node.left, list, k);
        list.add(node.val);
        inOrder(node.right, list, k);
    }

}
