package lettcode.interview;

import lettcode.tree.ListNode;

/**
 * 面试题18. 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class I18 {
    public static void main(String[] args) {
        ListNode node=new ListNode(new int[]{1,2,3,4,5,6});
        System.out.printf(""+new I18().deleteNode(node,1));
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (val == pre.next.val) {
                pre.next=pre.next.next;
            } else {
                pre=pre.next;
            }
        }
        return dummyHead.next;
    }
}
