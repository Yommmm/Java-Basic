package com.basic.leetcode;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution111 {

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (null == root) return 0;

        if (null == root.left && null == root.right) return 1;

        int minDepth = Integer.MAX_VALUE;
        if (null != root.left) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (null != root.right) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }

        return minDepth + 1;
    }

}
