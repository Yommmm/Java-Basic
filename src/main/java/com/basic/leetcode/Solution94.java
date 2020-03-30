package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.inorderTraversal(root, result);

        return result;
    }

    public void inorderTraversal(TreeNode node, List<Integer> result) {
        if (null == node) {
            return;
        }

        inorderTraversal(node.left, result);
        result.add(node.val);
        inorderTraversal(node.right, result);
    }

    public List<Integer> inorderTraversalNR(TreeNode node, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || node != null) {
            // 将树的左边的链的节点全部压栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                // 抛出栈中节点，将抛出节点的又节点压栈再出栈，保证中序遍历
                node = stack.peek();
                stack.pop();
                result.add(node.val);
                node = node.right;
            }

        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
