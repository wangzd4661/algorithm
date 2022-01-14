package lettcode.jzoffer;

import lettcode.tree.ListNode;


public class Q24 {
    public static void main(String[] args) {
        ListNode node = new Q24().reverseList(new ListNode(new int[]{1, 2, 3, 4, 5}));
        System.out.println(node);
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode p=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }
}
