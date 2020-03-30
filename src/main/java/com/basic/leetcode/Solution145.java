package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution145 {

    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.postorderTraversal(root, list);

        return list;

    }

    private void postorderTraversal(TreeNode node, List<Integer> list) {
        if (null == node) {
            return;
        }

        this.postorderTraversal(node.left, list);
        this.postorderTraversal(node.right, list);
        list.add(node.val);

    }

}
