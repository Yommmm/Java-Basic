package com.basic.leetcode;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode getList(int... nums) {
        ListNode node = new ListNode(nums[0]);
        ListNode tail = node;
        for(int i = 1; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }

        return node;
    }

    public static void printNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while(listNode != null) {
            sb.append(listNode.val + "->");
            listNode = listNode.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

}
