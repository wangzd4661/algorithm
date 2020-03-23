package lettcode.interview;

import lettcode.tree.ListNode;

/**
 * 面试题24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class I24 {
    public static void main(String[] args) {
        System.out.println("I24.main:" + reverseList(new ListNode(new int[]{1, 2,3,4,5})));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
