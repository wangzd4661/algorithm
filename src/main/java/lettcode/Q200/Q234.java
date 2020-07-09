package lettcode.Q200;

import lettcode.tree.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class Q234 {
    //时间O(n),空间O(n)
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int f = 0, l = list.size() - 1;
        while (f < l) {
            if (list.get(f).equals(list.get(l))) {
                f++;
                l--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 时间O(n),空间O(1)
     * 思路：快慢指针先找到中点,并翻转前半段链表
     */
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode sNext = slow.next;
            slow.next = pre;
            pre = slow;
            slow = sNext;
        }
        if (fast != null) {//奇数个，往后移一位
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != pre.val) return false;
            slow=slow.next;
            pre=pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(new ListNode(new int[]{1, 2,  2, 1})));
    }
}
