package com.basic.leetcode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution86 {

    public static void main(String[] args) {
        Solution86 solution = new Solution86();
        ListNode list = ListNode.getList(9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        ListNode partition = solution.partition(list, 5);
        ListNode.printNode(partition);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode(-1);
        ListNode dummyRight = new ListNode(-1);

        ListNode prevl = dummyLeft;
        ListNode prevr = dummyRight;

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = null;
            if (cur.val < x) {
                prevl.next = cur;
                prevl = prevl.next;
            } else {
                prevr.next = cur;
                prevr = prevr.next;
            }

            cur = next;
        }

        prevl.next = dummyRight.next;
        dummyRight.next = null;

        return dummyLeft.next;
    }

}
