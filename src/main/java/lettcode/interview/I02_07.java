package lettcode.interview;

import lettcode.tree.ListNode;

/**
 * 面试题 02.07. 链表相交
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */
public class I02_07 {
    public static void main(String[] args) {


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nA = headA;
        ListNode nB = headB;
        while (nA != nB) {
            nA = nA.next;
            nB = nB.next;
            if (nA == null && nB == null) return null;
            if(nA==null)nA=headB;
            if(nB==null)nB=headA;
        }
        return nA;
    }
}
