package com.basic.leetcode;

/**
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution404 {

    public static void main(String[] args) {
        TreeNode convert = TreeNode.convert(new Integer[]{1, 2, 3, 4, null, 5, 6, 7, null, null, null, 8});
        Solution404 solution = new Solution404();
        System.out.println(solution.sumOfLeftLeaves(convert));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return this.sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (null == node) return 0;

        int cur = 0;
        if (isLeft && null == node.left && null == node.right) cur = node.val;

        int left = sumOfLeftLeaves(node.left, true);
        int right = sumOfLeftLeaves(node.right, false);

        return cur + left + right;
    }

}
