package com.basic.leetcode;

/**
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 */
public class Solution5145 {

    public static void main(String[] args) {
        Solution5145 solution = new Solution5145();
//        TreeNode convert = TreeNode.convert(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
        TreeNode convert = TreeNode.convert(new Integer[]{50, null, 54, null, null, 98, 6, null, null, null, null, null, null, null, 34});
        System.out.println(solution.sumEvenGrandparent(convert));
    }

    private int sum;

    public int sumEvenGrandparent(TreeNode root) {
        this.sum(root);
        return sum;
    }

    private void sum(TreeNode node) {
        if (null == node) return;

        if (node.val % 2 == 0) {
            if (null != node.left) {
                sum += null == node.left.left ? 0 : node.left.left.val;
                sum += null == node.left.right ? 0 : node.left.right.val;
            }

            if (null != node.right) {
                sum += null == node.right.left ? 0 : node.right.left.val;
                sum += null == node.right.right ? 0 : node.right.right.val;
            }
        }

        sum(node.left);
        sum(node.right);
    }

}
