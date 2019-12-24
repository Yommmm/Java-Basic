package com.basic.leetcode;

/**
 *
 */
public class Solution101 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(null == left && null == right) return true;

        if(null == left || null == right) return false;

        return left.val == right.val && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }
}
