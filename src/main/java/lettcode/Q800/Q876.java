package lettcode.Q800;

import lettcode.tree.ListNode;

import java.util.ArrayList;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Q876 {
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5,6});
        ListNode node = new Q876().middleNode(head);
        System.out.printf(node.toString());
    }
}
