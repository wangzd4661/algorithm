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

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(new int[]{1, 2, 4, 2, 1})));
    }
}
