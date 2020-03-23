package lettcode.interview;

import lettcode.tree.ListNode;

import java.util.TreeSet;

/**
 * 面试题 02.01. 移除重复节点
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class I02_01 {

    public static void main(String[] args) {
        System.out.println("I02_01.main:" + removeDuplicateNodes(new ListNode(new int[]{1, 1, 1, 1, 2})));
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if(head==null)return null;
        TreeSet<Integer> set = new TreeSet<>();
        ListNode pre = head;
        set.add(pre.val);
        while (pre.next != null) {
            if (set.contains(pre.next.val)) {
                pre.next = pre.next.next;
            } else {
                set.add(pre.next.val);
                pre=pre.next;
            }
        }
        return head;
    }
}
