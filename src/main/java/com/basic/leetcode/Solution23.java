package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution23 {

    public static void main(String[] args) {
        Solution23 solution = new Solution23();
        ListNode list1 = solution.getList(1, 4, 7);
        ListNode list2 = solution.getList(2, 5, 8);
        ListNode list3 = solution.getList(3, 6, 9);

        ListNode listNode = solution.mergeKLists(new ListNode[]{list1, list2, list3});
        solution.printNode(listNode);
        ListNode listNode1 = solution.mergeKLists(new ListNode[]{list1, list2});
        solution.printNode(listNode1);
        ListNode listNode2 = solution.mergeKLists(new ListNode[]{list1});
        solution.printNode(listNode2);
        ListNode listNode3 = solution.mergeKLists(new ListNode[]{});
        solution.printNode(listNode3);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int length = lists.length;

        while (length > 1) {
            for (int i = 0; i < length >>> 1; i++) {
                lists[i] = this.mergeTwoLists(lists[i], lists[length - 1 - i]);
            }

            length = (length + 1) >>> 1;
        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);

        ListNode prev = dummyHead;
        // 总有个会先处理完
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 没处理完的链表接上
        prev.next = l1 == null ? l2 : l1;

        return dummyHead.next;
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
