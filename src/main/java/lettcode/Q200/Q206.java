package lettcode.Q200;

import lettcode.tree.ListNode;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Q206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    public ListNode reverseList2(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2});
        ListNode node = new Q206().reverseList2(head);
        System.out.printf(node.toString());
    }
}
