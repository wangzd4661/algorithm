package lettcode.Q100;

import lettcode.tree.ListNode;

/**
 * 160. 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class Q160 {
    //双指针 Time(O(m+n)) Space(O(1))
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nA = headA, nB = headB;
        while (nA != nB) {
            nA = nA.next;
            nB = nB.next;
            if (nA == null && nB == null) {
                return null;
            }
            if(nA==null){
                nA=headB;
            }
            if(nB==null){
                nB=headA;
            }
        }
        return nA;
    }
    //2.hash
}
