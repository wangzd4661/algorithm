package lettcode.Q001;

import lettcode.tree.ListNode;

/**
 * Created by Administrator on 2018/5/21.
 * 两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Q2 {
    public static void main(String[] args) {
        ListNode r = addTwoNumbers(new ListNode(new int[]{2,4,3}), new ListNode(new int[]{5,6,4}));
        System.out.println(r);
    }
    //Time O(n) Space O(1)
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp = null, result = null;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (temp == null) {
                temp = node;
                result = temp;
            } else {
                temp.next = node;
                temp = temp.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return result;
    }
}
