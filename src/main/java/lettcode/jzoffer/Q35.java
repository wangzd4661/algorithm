package lettcode.jzoffer;

import lettcode.tree.ListNode;

public class Q35 {
    public static void main(String[] args) {
        Node node = new Q35().copyRandomList(new Node(new int[]{1, 2, 3, 4, 5}));
        System.out.println(node);
    }
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node node=head;
        Node dummy=new Node(-1);
        Node cur,pre=dummy;
        while (node!=null){
            cur=new Node(node.val);
            pre.next=cur;
            pre=cur;
            node=node.next;
        }
        return dummy.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        Node cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }

    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node cur = this;
        while (cur != null) {
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
