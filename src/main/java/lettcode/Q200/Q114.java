package lettcode.Q200;

import lettcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Q114 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        flatten(n1);
    }

    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode treeNode = list.get(i);
            treeNode.right = list.get(i + 1);
            treeNode.left = null;
        }
        TreeNode treeNode = root;
        while (treeNode != null) {
            System.out.print(treeNode.val + ",");
            treeNode = treeNode.right;
        }
    }

    public static void preOrder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
        root.left = null;
    }

}
