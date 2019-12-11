package com.basic.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution83 {

    public static void main(String[] args) {
        Solution83 solution = new Solution83();
        ListNode listNode = solution.getList(1, 2, 2, 3, 3, 4, 4, 5, 5, 7, 7, 8, 8, 9);
//        ListNode listNode = solution.getList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        solution.printNode(listNode);
        ListNode result = solution.deleteDuplicates2(listNode);
        solution.printNode(result);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && cur.val == cur.next.val) {
                cur.next = next.next;
                next.next = null;
            } else {
                cur = cur.next;
            }

        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;

        if(head.val == head.next.val) {
            head = deleteDuplicates2(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
        }

        return head;
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
