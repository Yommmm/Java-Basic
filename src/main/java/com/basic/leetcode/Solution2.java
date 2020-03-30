package com.basic.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode list1 = solution.getList(1);
        ListNode list2 = solution.getList(9, 9, 9);
        ListNode listNode = solution.addTwoNumbers2(list1, list2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

    /**
     * O(Max(l1.length,l2.length))
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);

        ListNode prev = dummyHead;
        int up = 0;
        while (l1 != null && l2 != null) {
            int newVal = l1.val + l2.val + up;
            up = newVal >= 10 ? 1 : 0;
            prev.next = new ListNode(newVal % 10);
            prev = prev.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        l1 = l1 == null ? l2 : l1;

        while (l1 != null) {
            int newVal = l1.val + up;
            up = newVal >= 10 ? 1 : 0;
            prev.next = new ListNode(newVal % 10);

            prev = prev.next;
            l1 = l1.next;
        }

        if (l1 == null && up == 1) {
            prev.next = new ListNode(up);
        }

        return dummyHead.next;
    }

    /**
     * 时间复杂度一致
     * 简化写法，短链表默认相同长度，空节点默认为 0
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);

        ListNode prev = dummyHead;
        int up = 0;
        while (l1 != null || l2 != null) {
            int newVal = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + up;
            up = newVal >= 10 ? 1 : 0;
            prev.next = new ListNode(newVal % 10);
            prev = prev.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (up == 1) {
            prev.next = new ListNode(up);
        }

        return dummyHead.next;
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
