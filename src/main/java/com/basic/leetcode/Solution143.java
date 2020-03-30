package com.basic.leetcode;

import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Solution143 {

    public static void main(String[] args) {
        Solution143 solution = new Solution143();
        ListNode list = ListNode.getList(1, 2);
        solution.reorderList(list);
    }

    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        ListNode cur = head;
        while (null != cur) {
            stack.push(cur);
            cur = cur.next;
        }

        if (stack.size() < 3) return;

        ListNode c = head;
        for (int i = 0; i < stack.size(); i++) {
            ListNode pop = stack.pop();
            pop.next = c.next;
            c.next = pop;
            c = pop.next;
        }

        c.next = null;
        ListNode.printNode(head);
    }

    public void reorderList1(ListNode head) {
        ListNode cur = head;
        while (null != cur) {
            cur.next = reverse(cur.next);
            cur = cur.next;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
