package lettcode.Q001;

import java.util.HashSet;
import java.util.Set;

/**
 * 83. 删除排序链表中的重复元素
 */
public class Q83 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode r = new Q83().deleteDuplicates3(n1);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet();
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            int val = node.val;
            if (set.add(val)) {
                pre = node;
            } else {
                pre.next = node.next;
            }
            node = node.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode node = head.next;
        ListNode pre = head;
        while (node != null) {
            int val = node.val;
            int preVal = pre.val;
            if (preVal != val) {
                pre = node;
            } else {
                pre.next = node.next;
            }
            node = node.next;
        }
        return head;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            int val = cur.val;
            int nextVal = cur.next.val;
            if (nextVal == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
