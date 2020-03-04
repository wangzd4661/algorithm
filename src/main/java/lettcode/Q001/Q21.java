package lettcode.Q001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 * <p>
 * 21.合并两个有序链表
 */
public class Q21 {
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
        ListNode l2 = null;
        l2 = mergeTwoLists(first, first);
        List<Integer> s = nodeToArray(l2);
        System.out.println(s + "");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = null, result = null;
        List<Integer> list1 = nodeToArray(l1);
        List<Integer> list2 = nodeToArray(l2);
        list1.addAll(list2);
        Collections.sort(list1);
        for (int i = 0; i < list1.size(); i++) {
            ListNode newNode = new ListNode(list1.get(i));
            if (temp == null) {
                temp = newNode;
                result = temp;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
        }
        return result;
    }

    public static List<Integer> nodeToArray(ListNode l) {
        List<Integer> nums = new ArrayList<>();
        while (true) {
            if (l == null) {
                return nums;
            }
            nums.add(l.val);
            if (l.next == null) {
                break;
            } else {
                l = l.next;
            }
        }
        return nums;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode l;
        if (l1.val < l2.val) {
            l = new ListNode(l1.val);
            l.next = mergeTwoLists(l1.next, l2);
        } else {
            l = new ListNode(l2.val);
            l.next = mergeTwoLists(l1, l2.next);
        }
        return l;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
