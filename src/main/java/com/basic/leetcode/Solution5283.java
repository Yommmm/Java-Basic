package com.basic.leetcode;

/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * 请你返回该链表所表示数字的 十进制值 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 *
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 *
 * 输入：head = [0,0]
 * 输出：0
 */
public class Solution5283 {

    public static void main(String[] args) {
        Solution5283 solution = new Solution5283();
        ListNode list = solution.getList(1,0,1,0,1);
        System.out.println(solution.getDecimalValue2(list));
    }

    int sum = 0;

    public int getDecimalValue(ListNode head) {
        int rc = this.rc(head);
        return sum + rc * head.val;
    }

    public int rc(ListNode head) {
        if(head.next == null) {
            return 1;
        }

        int i = rc(head.next);
        sum = sum + head.next.val * i;
        return i * 2;
    }

    /**
     * 1 0 1 0 1
     * (((1 * 2) + 0) * 2) + 1) * 2) + 0) * 2) + 1
     * @param head
     * @return
     */
    public int getDecimalValue2(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum <<= 1;
            sum = head.val + sum;
            head = head.next;
        }

        return sum;
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
        for(int i = 1; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }

        return node;
    }

    public void printNode(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while(listNode != null) {
            sb.append(listNode.val + "->");
            listNode = listNode.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}
