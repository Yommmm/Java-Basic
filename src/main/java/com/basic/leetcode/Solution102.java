package com.basic.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution102 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            this.levelOrder(root, 0, result);
        }
        return result;
    }

    private void levelOrder(TreeNode node, int level, List<List<Integer>> result) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        if (null != node.left) {
            levelOrder(node.left, level + 1, result);
        }

        if (null != node.right) {
            levelOrder(node.right, level + 1, result);
        }
    }

}
