package com.basic.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * 递归回溯
 * 递归到底，回溯N次，处理节点
 */
public class Solution19 {

    public static void main(String[] args) {
        Solution19 solution = new Solution19();
        ListNode list = solution.getList(1, 2, 3, 4, 5, 6, 7);
        ListNode listNode = solution.removeNthFromEnd(list, 1);
        solution.printNode(listNode);

        ListNode list1 = solution.getList(1, 2, 3, 4, 5, 6, 7);
        ListNode listNode1 = solution.removeNthFromEnd(list1, 2);
        solution.printNode(listNode1);

        ListNode list2 = solution.getList(1, 2, 3, 4, 5, 6, 7);
        ListNode listNode2 = solution.removeNthFromEnd(list2, 3);
        solution.printNode(listNode2);

        ListNode list3 = solution.getList(1, 2, 3, 4, 5, 6, 7);
        ListNode listNode3 = solution.removeNthFromEnd(list3, 4);
        solution.printNode(listNode3);

        ListNode list4 = solution.getList(1, 2, 3, 4, 5, 6, 7);
        ListNode listNode4 = solution.removeNthFromEnd(list4, 5);
        solution.printNode(listNode4);

        ListNode list5 = solution.getList(1, 2, 3, 4, 5, 6, 7);
        ListNode listNode5 = solution.removeNthFromEnd(list5, 6);
        solution.printNode(listNode5);

        ListNode list6 = solution.getList(1, 2, 3, 4, 5, 6, 7);
        ListNode listNode6 = solution.removeNthFromEnd(list6, 7);
        solution.printNode(listNode6);

        ListNode list7 = solution.getList(1, 2, 3, 4, 5, 6, 7);
        ListNode listNode7 = solution.removeNthFromEnd(list7, 8);
        solution.printNode(listNode7);

        ListNode list0 = solution.getList(1, 2, 3, 4, 5, 6, 7);
        ListNode listNode0 = solution.removeNthFromEnd(list0, 0);
        solution.printNode(listNode0);

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return head;
        }

        int remove = remove(head, n);
        if(remove == n) {
            return head.next;
        }
        return head;
    }

    private int remove(ListNode head, int n) {
        if(head == null) {
            return 0;
        }

        int removeIndex = remove(head.next, n);
        if(n == removeIndex) {
            if(null != head.next) {
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = null;
            } else {
                head.next = null;
            }
            return Integer.MIN_VALUE;
        } {
            return removeIndex + 1;
        }
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

}
