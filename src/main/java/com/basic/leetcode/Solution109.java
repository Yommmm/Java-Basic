package com.basic.leetcode;

public class Solution109 {

    public static void main(String[] args) {
        /*ListNode list = ListNode.getList(1, 2, 3, 4);

        ListNode fast = list;
        ListNode low = list;
        ListNode prev = null;
        while (null != fast && null != fast.next) {
            prev = low;
            fast = fast.next.next;
            low = low.next;
        }
        System.out.println("low.val = " + low.val);
        System.out.println("prev.val = " + prev.val);*/

        Solution109 solution = new Solution109();
        ListNode list = ListNode.getList(1, 2, 3, 4);
        TreeNode treeNode = solution.sortedListToBST(list);
        System.out.println(treeNode);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (null == head.next) {
            return new TreeNode(head.val);
        }

        ListNode fast = head;
        ListNode low = head;
        ListNode prev = null;
        while (null != fast && null != fast.next) {
            prev = low;
            fast = fast.next.next;
            low = low.next;
        }

        TreeNode node = new TreeNode(low.val);

        if (null != prev) {
            prev.next = null;
        }

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(low.next);

        if (null != low) {
            low.next = null;
        }

        return node;
    }

}
