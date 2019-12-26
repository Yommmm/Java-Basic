package com.basic.leetcode;

import com.basic.datastruct.array.Array;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution105 {

    public static void main(String[] args) {
        Solution105 solution = new Solution105();
        TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);

        TreeNode treeNode1 = solution.buildTree(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4});
        System.out.println(treeNode1);

//        solution.removeFirst(new int[]{1,2,3,4,5});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(0 == preorder.length || 0 == inorder.length) {
            return null;
        }

        // 前序遍历数组第一个元素为根节点
        TreeNode node = new TreeNode(preorder[0]);

        // 找到根节点在中序遍历中的位置
        int i = 0;
        while (node.val != inorder[i]) {
            i++;
        }

        int[] left = new int[i];
        int[] right = new int[inorder.length - i - 1];

        System.arraycopy(inorder, 0, left, 0, i);
        System.arraycopy(inorder, i + 1, right, 0, inorder.length - i - 1);

        if (i != 0) {
            removeFirst(preorder);
            node.left = buildTree(preorder, left);
        }

        if (i != inorder.length - 1) {
            removeFirst(preorder);
            node.right = buildTree(preorder, right);
        }

        return node;
    }

    private void removeFirst(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            arr[i] = arr[i + 1];
            i++;
        }
    }

}
