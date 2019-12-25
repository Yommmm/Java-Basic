package com.basic.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution103 {

    public static void main(String[] args) {
        System.out.println(0 & 1);
        System.out.println(1 & 1);
        System.out.println(2 & 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) {
            this.zigzagLevelOrder(root, 0, result);
            for(int i = 1; i < result.size(); i += 2) {
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }

    private void zigzagLevelOrder(TreeNode node, int level, List<List<Integer>> result) {
        if(result.size() == level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        if(null != node.left) {
            zigzagLevelOrder(node.left, level + 1, result);
        }

        if(null != node.right) {
            zigzagLevelOrder(node.right, level + 1, result);
        }
    }

}