package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

import java.util.List;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution92 {

    public static void main(String[] args) {

        Solution92 solution = new Solution92();

        ListNode listNode = ListNode.getList(1, 2, 3, 4, 5);
        ListNode.printNode(solution.reverseBetween(listNode, 2, 3));

        ListNode listNode2 = ListNode.getList(1, 2, 3, 4, 5);
        ListNode.printNode(solution.reverseBetween(listNode2, 1, 5));

        ListNode listNode3 = ListNode.getList(1, 2, 3, 4, 5);
        ListNode.printNode(solution.reverseBetween(listNode3, 4, 5));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;

        int index = 1;
        while (index < m) {
            prev = prev.next;
            index++;
        }

        prev.next = this.reverseList(prev.next, n - m);

        return dummyNode.next;
    }

    public ListNode reverseList(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;

        int index = 0;
        while (cur != null && index <= k) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;

            cur = next;
            index ++;
        }

        head.next = cur;
        return prev;
    }

}
