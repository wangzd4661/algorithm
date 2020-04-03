package lettcode.interview;

import lettcode.tree.ListNode;

/**
 * 面试题22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class I22 {
    public static void main(String[] args) {
        System.out.printf(""+getKthFromEnd(new ListNode(new int[]{1,2,3,4,5}),6));
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (k != 0 && fast != null) {//fast先走k步
            fast = fast.next;
            k--;
        }
        if(fast==null)return null;//走过了
        while (fast!=null){//再一起走
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
