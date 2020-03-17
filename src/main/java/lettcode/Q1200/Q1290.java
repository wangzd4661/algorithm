package lettcode.Q1200;

import lettcode.tree.ListNode;

public class Q1290 {
    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.valueOf(sb.toString(), 2);
    }

    public static int getDecimalValue2(ListNode head) {
        int a = 0;
        while (head != null) {
            a = a * 2 + head.val;
            head = head.next;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getDecimalValue2(new ListNode(new int[]{1, 0})));
    }
}
