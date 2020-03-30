package com.basic.datastruct.linkedlist;

public class ListNode {

    int val;

    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] arr) {
        if (null == arr || arr.length == 0)
            throw new IllegalArgumentException("Init faild, arr is empty!");

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            res.append(node.val + " -> ");
            node = node.next;
        }
        res.append("NULL");
        return res.toString();
    }

}
