package lettcode.interview;

import lettcode.tree.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class I02_02 {
    public static void main(String[] args) {
        System.out.printf("" + kthToLast(new ListNode(new int[]{1, 2, 3, 4, 5}), 6));
    }

    public static int kthToLast(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (k != 0 && fast != null) {
            fast=fast.next;
            k--;
        }
        while (fast!=null&&slow!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow.val;
    }
}
