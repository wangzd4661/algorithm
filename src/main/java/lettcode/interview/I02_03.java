package lettcode.interview;

import lettcode.tree.ListNode;

/**
 * 面试题 02.03. 删除中间节点
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */
public class I02_03 {
    public static void main(String[] args) {
        deleteNode(new ListNode(new int[]{1, 2, 3, 4, 5, 6}));
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
        System.out.printf("" + node);
    }
}
