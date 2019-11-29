package com.basic.leetcode;

public class Solution21 {

    public static void main(String[] args) {
        Solution21 solution = new Solution21();

        ListNode l1 = solution.getList(1, 3, 5, 7, 9);
        ListNode l2 = solution.getList(2, 4, 6, 8, 10);
        ListNode listNode = solution.mergeTwoLists2(l1, l2);
        System.out.println();
        System.out.println();
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode newNode = l2;
            l2 = l2.next;

            // l2 从第一个元素开始往 l1 里面塞，时间复杂度O(n)
            ListNode cur = l1;
            ListNode prev = null;
            while(cur != null && newNode.val > cur.val) {
                prev = cur;
                cur = cur.next;
            }
            if(prev == null) {
                l1 = newNode;
            } else {
                prev.next = newNode;
            }
            newNode.next = cur;
        }

        return l1;
    }

    /**
     * 迭代方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);

        ListNode prev = dummyHead;
        // 总有个会先处理完
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
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

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
