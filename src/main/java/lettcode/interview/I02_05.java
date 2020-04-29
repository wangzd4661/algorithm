package lettcode.interview;

import lettcode.tree.ListNode;

/**
 * 面试题 02.05. 链表求和
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 */
public class I02_05 {
    public static void main(String[] args) {
        ListNode r = addTwoNumbers(new ListNode(new int[]{2, 4, 3}), new ListNode(new int[]{5, 6, 4}));
        System.out.println(r);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode temp = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (temp == null) {
                temp = node;
                ret = temp;
            } else {
                temp.next = node;
                temp=node;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return ret;
    }
}
