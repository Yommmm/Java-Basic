package com.basic.leetcode;

import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 *  
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution445 {

    public static void main(String[] args) {
        Solution445 solution = new Solution445();
        ListNode listNode = solution.addTwoNumbers(ListNode.getList(1, 2, 3, 4, 5), ListNode.getList(3, 4, 5));
        ListNode.printNode(listNode);

        ListNode listNode2 = solution.addTwoNumbers(ListNode.getList(0), ListNode.getList(0));
        listNode.printNode(listNode2);

        ListNode listNode3 = solution.addTwoNumbers(ListNode.getList(5), ListNode.getList(5));
        listNode.printNode(listNode3);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int val1 = 0;
        int val2 = 0;

        while (null != l1 || null != l2) {
            if (null != l1) {
                val1 = val1 * 10 + l1.val;
                l1 = l1.next;
            }

            if (null != l2) {
                val2 = val2 * 10 + l2.val;
                l2 = l2.next;
            }
        }

        int value = val1 + val2;
        if (value == 0) return new ListNode(0);

        ListNode next = null;
        while (value > 0) {
            ListNode listNode = new ListNode(value % 10);
            listNode.next = next;
            next = listNode;
            value /= 10;
        }

        return next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (null != l1 || null != l2) {
            if (null != l1) {
                stack1.push(l1.val);
                l1 = l1.next;
            }

            if (null != l2) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }

        ListNode head = null;
        int add = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int i = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + add;
            if(i >= 10) {
                i -= 10;
                add = 1;
            } else{
                add = 0;
            }
            ListNode listNode = new ListNode(i);
            listNode.next = head;
            head = listNode;
        }

        if(add == 1) {
            ListNode listNode = new ListNode(1);
            listNode.next = head;
            return listNode;
        }

        return head;
    }

}
