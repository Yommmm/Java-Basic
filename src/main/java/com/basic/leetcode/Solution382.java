package com.basic.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 *
 * 示例:
 *
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-random-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution382 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        private ListNode head;
        private Random rand = new Random();

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode res = head;
            ListNode cur = head.next;
            int i = 2;
            //从第二个节点开始,每次循环替换res的概率都是1/i
            while(cur != null){
                int ran = rand.nextInt(i);
                if(ran == 0){
                    res = cur;
                }
                cur = cur.next;
                i++;
            }
            return res.val;
        }
    }

    class Solution2 {

        private List<ListNode> list;
        private Random rand = new Random();

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution2(ListNode head) {
            list = new ArrayList<>();
            while (null != head) {
                list.add(head);
                head = head.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size())).val;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

}
