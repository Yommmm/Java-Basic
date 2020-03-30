package com.basic.datastruct.linkedlist;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 4, 5, 6, 7, 8, 6};
        ListNode node = new ListNode(arr);

        System.out.println(node);

        removeElement3(node, 6);
        System.out.println(node);

        System.out.println(sum(arr, 0));
    }

    public static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        } else {
            return sum(arr, l + 1) + arr[l];
        }
    }

    public static ListNode removeElement(ListNode head, int val) {
        while (null != head && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (null == head) {
            return null;
        }

        ListNode prev = head;
        while (null != prev.next) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

    public static ListNode removeElement1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (null != prev.next) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public static ListNode removeElement2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (null != prev.next) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * 递归方法基本法
     * 1.基本问题解决
     * 2.划分为最小问题
     * 3.最小问题解拼装成原问题的解
     * <p>
     * 系统栈空间占用，底层时间消耗
     * StackOverflow
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElement3(ListNode head, int val) {
        if (null == head) {
            return null;
        }

        // 划分为最小问题，从第9个节点开始处理
        ListNode res = removeElement3(head.next, val);

        // 如果是节点val与条件val相同，返回下一个节点，反之返回当前节点
        if (head.val == val) {
            head.next = null;
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public static ListNode removeElement4(ListNode head, int val) {
        if (null == head) {
            return null;
        }

        // 划分为最小问题，从第9个节点开始处理
        head.next = removeElement4(head.next, val);

        // 如果是节点val与条件val相同，返回下一个节点，反之返回当前节点
        return head.val == val ? head.next : head;
    }

}
