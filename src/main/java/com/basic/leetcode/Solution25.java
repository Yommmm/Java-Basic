package com.basic.leetcode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Solution25 {

    public static void main(String[] args) {
        Solution25 solution = new Solution25();
        ListNode list = solution.getList(1, 2, 3, 4, 5, 6, 7);
        list = solution.reverse(list);
        ListNode listNode = solution.reverseKGroup(list, 2);
        solution.printNode(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);

        dummyHead.next = head;
        ListNode left = dummyHead;
        ListNode right = dummyHead;

        while(left != null) {
            int i = 0;
            while(i < k && right != null) {
                right = right.next;
                i++;
            }

            if(right == null) {
                break;
            }

            ListNode next = right.next;

            ListNode start = left.next;
            right.next = null;
            left.next = reverse(start);
            start.next = next;
            left = start;

            right = left;
        }

        return dummyHead.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        while(cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;

            cur = next;
        }

        return pre;
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
        for(int i = 1; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }

        return node;
    }

    public void printNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while(listNode != null) {
            sb.append(listNode.val + "->");
            listNode = listNode.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}
