package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution257 {

    public static void main(String[] args) {
        Solution257 solution = new Solution257();
        solution.binaryTreePaths(null);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, "", result);
        return result;
    }

    private void binaryTreePaths(TreeNode node, String temp, List<String> result) {
        if (node != null) {
            temp += Integer.toString(node.val);
            if (null == node.left && null == node.right) {
                result.add(temp);
            } else {
                temp += "->";  // 当前节点不是叶子节点，继续递归遍历
                binaryTreePaths(node.left, temp, result);
                binaryTreePaths(node.right, temp, result);
            }
        }
    }

}
