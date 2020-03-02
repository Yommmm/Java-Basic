package com.basic.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution671 {

    public static void main(String[] args) {
        Solution671 solution = new Solution671();
        TreeNode convert = TreeNode.convert(new Integer[]{2, 2, 3});
        System.out.println(solution.findSecondMinimumValue2(convert));
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return -1;

        int left = root.left.val;
        int right = root.right.val;

        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }

        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        if (left != -1) {
            return left;
        }

        return right;
    }

    public int findSecondMinimumValue2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return -1;

        Set<Integer> set = new LinkedHashSet<>();
        this.order(root, set);

        if(set.size() < 2) return -1;

        ArrayList<Integer> integers = new ArrayList<>(set);
        integers.sort((a, b) -> a - b);
        return integers.get(1);
    }

    private void order(TreeNode node, Set<Integer> set) {
        if (null == node) return;

        set.add(node.val);
        this.order(node.left, set);
        this.order(node.right, set);
    }

}
