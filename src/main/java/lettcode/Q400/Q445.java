package lettcode.Q400;

import lettcode.tree.ListNode;

import java.util.LinkedList;

/**
 * 445. 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class Q445 {
    public static void main(String[] args) {
        ListNode r = new Q445().addTwoNumbers(new ListNode(new int[]{7, 2, 4, 3}), new ListNode(new int[]{5, 6, 4}));
        System.out.println(r);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();
        int carry = 0;
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode ret = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = (stack1.isEmpty() ? 0 : stack1.pop().val) + (stack2.isEmpty() ? 0 : stack2.pop().val) + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (ret != null) {
                node.next = ret;
            }
            ret = node;
        }
        return ret;
    }
}
