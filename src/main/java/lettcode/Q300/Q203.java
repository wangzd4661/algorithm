package lettcode.Q300;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Q203 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode r = removeElements(n1, 2);
        while (r != null) {
            System.out.print(r.val + ",");
            r = r.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode myHead = new ListNode(0);
        myHead.next = head;
        ListNode cur=myHead;
        while (cur.next != null) {
            if (val == cur.next.val) {
                cur.next =cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return myHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
