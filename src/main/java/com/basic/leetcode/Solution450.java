package com.basic.leetcode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * 示例:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * <p>
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution450 {

    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        root = remove(root, key);
        return root;
    }

    private TreeNode remove(TreeNode node, int key) {
        if (null == node)
            return null;

        if ((key - node.val) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if ((key - node.val) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { // (e - node.val) == 0
            // 如果左子树为空，直接返回delNode的【右子树】给delNode父亲的子节点
            if (null == node.left) {
                TreeNode rightNode = node.right;
                node.right = null;
                return rightNode;
            }

            // 如果右子树为空，直接返回delNode的【左子树】给delNode父亲的子节点
            if (null == node.right) {
                TreeNode leftNode = node.left;
                node.left = null;
                return leftNode;
            }

            // 左右子树都不为空的情况下，选中右子树的最小节点【后继】或者左子树的最大节点【前驱】
            TreeNode successor = minimum(node.right); // 找到右子树那个最小的后继节点
            successor.right = removeMin(node.right); // 删掉那个右子树上最小的后继节点
            successor.left = node.left;

            node.left = node.right = null; // delNode与树脱离关系

            return successor;
        }

    }

    /**
     * 找最小值
     *
     * @param node
     * @return
     */
    private TreeNode minimum(TreeNode node) {
        if (null == node.left)
            return node;

        return minimum(node.left);
    }

    /**
     * 移除最小值
     *
     * @param node
     * @return
     */
    private TreeNode removeMin(TreeNode node) {
        if (null == node.left) {
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

}
