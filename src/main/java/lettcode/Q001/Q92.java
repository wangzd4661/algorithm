package lettcode.Q001;

import lettcode.tree.ListNode;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class Q92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre=null;
        ListNode cur=head;
        int count=0;
        while (cur!=null){
            count++;
            if(count>=m&&count<=n){
                ListNode next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }else if(count>n){
                break;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2,3,4,5});
        ListNode node = new Q92().reverseBetween(head,2,4);
        System.out.printf(node.toString());
    }
}
