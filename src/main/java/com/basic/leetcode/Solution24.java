package com.basic.leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution24 {

    public static void main(String[] args) {
        Solution24 solution = new Solution24();

        ListNode head = solution.getList(1, 2, 3, 4, 5);
        solution.printNode(head);
        ListNode listNode = solution.swapPairs2(head);
        solution.printNode(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next != null) {
            head.next.next = swapPairs(head.next.next);

            ListNode next = head.next;
            head.next = next.next;
            next.next = head;

            head = next;
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        next.next = swapPairs(head.next.next);

        head.next = next.next;
        next.next = head;

        return next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getList(int... nums) {
        ListNode node = new ListNode(nums[0]);
        ListNode tail = node;
        for (int i = 1; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }

        return node;
    }

    public void printNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val + "->");
            listNode = listNode.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

}
