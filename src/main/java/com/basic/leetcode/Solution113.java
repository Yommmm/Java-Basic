package com.basic.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution113 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.convert(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});

        Solution113 solution = new Solution113();
        List<List<Integer>> lists = solution.pathSum(root, 22);
        System.out.println(lists);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        this.pathSum(root, sum, new ArrayList<>(), result);
        return result;
    }

    private void pathSum(TreeNode node, int sum, List<Integer> temp, List<List<Integer>> result) {
        if (null == node) return;

        temp.add(node.val);
        sum -= node.val;
        if (0 == sum && null == node.left && null == node.right) {
            result.add(new ArrayList<>(temp));
        } else {
            pathSum(node.left, sum, temp, result);
            pathSum(node.right, sum, temp, result);
        }

        temp.remove(temp.size() - 1);
    }

}
