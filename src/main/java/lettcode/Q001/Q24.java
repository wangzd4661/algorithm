package lettcode.Q001;

import lettcode.tree.ListNode;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Q24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l1 = head;
        ListNode l2 = head.next;

        l1.next = swapPairs(l2.next);
        l2.next = l1;
        return l2;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1=p.next;
            ListNode node2=node1.next;
            ListNode next=node2.next;
            node2.next=node1;
            node1.next=next;
            p.next=node2;
            p=node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = swapPairs2(new ListNode(new int[]{1, 2, 3, 4}));
        System.out.print(node);
    }
}

