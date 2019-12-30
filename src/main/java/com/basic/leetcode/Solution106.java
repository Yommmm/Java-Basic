package com.basic.leetcode;

import java.util.HashMap;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution106 {

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postOrder = new int[]{9, 15, 7, 20, 3};

        Solution106 solution = new Solution106();
        TreeNode treeNode = solution.buildTree(inorder, postOrder);
        System.out.println(treeNode);
    }

    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int instart, int inend, int poststart, int postend) {
        if (inend < instart || postend < poststart) return null;

        int root = post[postend];
        int rootIndex = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(instart, rootIndex - 1, poststart, poststart + rootIndex - instart - 1);
        node.right = buildTree(rootIndex + 1, inend, poststart + rootIndex - instart, postend - 1);
        return node;
    }

}
