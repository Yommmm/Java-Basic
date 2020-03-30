package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution206 {

    public static void main(String[] args) {
        Solution206 solution = new Solution206();

        ListNode listNode = solution.reverseList(ListNode.getList(1, 2, 3, 4, 5));
        ListNode.printNode(listNode);

        ListNode listNode2 = solution.reverseList1(ListNode.getList(1, 2, 3, 4, 5));
        ListNode.printNode(listNode2);
    }

    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return prev;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;

            cur = next;
        }

        return prev;
    }

}
