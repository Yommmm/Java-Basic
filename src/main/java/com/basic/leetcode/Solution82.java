package com.basic.leetcode;

import com.basic.datastruct.map.Solution;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution82 {

    public static void main(String[] args) {
        Solution82 solution = new Solution82();
        ListNode listNode = ListNode.getList(5, 5, 5);
        ListNode listNode1 = solution.deleteDuplicates(listNode);
        ListNode.printNode(listNode1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            // 如果当前节点值与后继节点值不同，刷新前驱节点
            if (cur.val != cur.next.val) {
                prev = cur;
                cur = cur.next;
            } else {
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                prev.next = cur.next;
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

}
