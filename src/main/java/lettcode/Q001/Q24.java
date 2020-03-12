package lettcode.Q001;

import lettcode.tree.ListNode;

public class Q24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l1 = head;
        ListNode l2 = head.next;

        l1.next = swapPairs(l2.next);
        l2.next = l1;
        return l2;
    }

    public static void main(String[] args) {
        ListNode node = swapPairs(new ListNode(new int[]{1, 2, 3, 4}));
        System.out.print(node);
    }
}

