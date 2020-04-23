package lettcode.Q200;

import lettcode.tree.ListNode;

public class Q237 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        new Q237().deleteNode(n1);
        while (n1!=null){
            System.out.printf(""+n1.val);
            n1=n1.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
