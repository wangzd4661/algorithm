package lettcode.Q100;

/**
 * Created by Administrator on 2018/5/21.
 * 两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Q2 {
    public static void main(String[] args) {
        ListNode first = new ListNode(0);
        ListNode l = null;
        for (int i = 1; i < 4; i++) {
            ListNode newNode = new ListNode(i);
            if (l == null) {
                first.next = newNode;
            } else {
                l.next = newNode;
            }
            l = newNode;
        }
        ListNode r = addTwoNumbers(first, first);

        int s = nodeToNum(r);
        System.out.print(s);
    }

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

    public static int nodeToNum(ListNode l) {
        int num = 0;
        int size = 0;
        while (true) {
            if (l == null) {
                return 0;
            }
            num = (int) (num + (l.val) * Math.pow(10, size));
            size++;
            if (l.next == null) {
                break;
            } else {
                l = l.next;
            }
        }
        return num;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
