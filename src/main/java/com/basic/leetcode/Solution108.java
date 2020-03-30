package com.basic.leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution108 {

    public static void main(String[] args) {
        Solution108 solution = new Solution108();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }

        int i = nums.length / 2;
        TreeNode node = new TreeNode(nums[i]);

        int[] left = new int[i];
        int[] right = new int[nums.length - i - 1];

        System.arraycopy(nums, 0, left, 0, i);
        System.arraycopy(nums, i + 1, right, 0, nums.length - i - 1);

        if (0 != left.length) {
            node.left = sortedArrayToBST(left);
        }

        if (0 != right.length) {
            node.right = sortedArrayToBST(right);
        }

        return node;
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }

        return this.sortedArrayToBST2(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST2(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBST2(nums, start, mid - 1);
        node.right = sortedArrayToBST2(nums, mid + 1, end);

        return node;
    }

}
