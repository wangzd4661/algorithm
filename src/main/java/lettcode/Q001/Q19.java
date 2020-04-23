package lettcode.Q001;

import lettcode.tree.ListNode;

import java.util.ArrayList;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (list.size() == 1) return null;//一个元素直接删除完
        int removePos = list.size() - n;
        int retPos = 0;
        if (removePos - 1 < 0) {//删除头结点单独处理
            retPos = 1;
        } else if (removePos + 1 >= list.size()) {//删除尾节点
            list.get(removePos - 1).next = null;
        } else {
            list.get(removePos - 1).next = list.get(removePos + 1);
            list.get(removePos).next = null;
        }
        return list.get(retPos);
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next=head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2});
        ListNode node = new Q19().removeNthFromEnd2(head, 1);
        System.out.printf(node.toString());
    }
}
