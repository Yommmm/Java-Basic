package com.basic.leetcode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution148 {

    public static void main(String[] args) {
        Solution148 solution = new Solution148();

        ListNode list = ListNode.getList(9, 8, 7, 6);
        ListNode listNode = solution.sortList(list);
        ListNode.printNode(listNode);
    }

    /**
     * 归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode h = new ListNode(0);
        ListNode result = h;

        while (null != left && null != right) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        h.next = null == left ? right : left;

        return result.next;
    }

}
