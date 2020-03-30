package com.basic.leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution203 {

    public static void main(String[] args) {
        ListNode list = ListNode.getList(1, 2, 6, 3, 4, 5, 6);
        Solution203 solution = new Solution203();
        ListNode listNode = solution.removeElements(list, 6);
        ListNode.printNode(listNode);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = head;

        while (null != cur) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur.next = null;
                cur = prev.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

}
