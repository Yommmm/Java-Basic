package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution114 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.convert(new Integer[]{1, 2, 5, 3, 4, null, 6});

        Solution114 solution = new Solution114();
        solution.flatten(root);
    }

    private TreeNode next;

    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = next;
        root.left = null;
        next = root;
    }

}
