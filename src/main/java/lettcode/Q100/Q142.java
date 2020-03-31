package lettcode.Q100;

import lettcode.tree.ListNode;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Q142 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        //n5.next = n2;
        System.out.println(""+detectCycle(n1));
    }

    /**
     * fast走2k步，slow走k步，有环则相遇。假设相遇点距环起始点距离为m
     * head到环为k-m。环剩余也为k-m
     *
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)break;
        }
        if(fast==null||fast.next==null)return null;
        slow=head;
        while (slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

}
