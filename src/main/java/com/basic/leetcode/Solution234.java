package com.basic.leetcode;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution234 {

    public static void main(String[] args) {
        Solution234 solution = new Solution234();
        System.out.println(solution.isPalindrome2(ListNode.getList(1, 2, 3, 2, 1)));
    }

    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return true;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode slow = head;
        ListNode fast = head;

        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            stack.push(slow);
            if (null != fast) {
                slow = slow.next;
            }
        }

        ListNode cur = slow.next;
        while (!stack.isEmpty() && null != cur) {
            if (stack.pop().val != cur.val) {
                return false;
            }
            cur = cur.next;
        }

        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        ListNode left = null;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            left = slow;
            slow = slow.next;
            fast = fast.next.next;
            left.next = prev;
            prev = left;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (left != null && slow != null) {
            if (left.val != slow.val) {
                return false;
            }
            left = left.next;
            slow = slow.next;
        }
        return true;
    }

}
