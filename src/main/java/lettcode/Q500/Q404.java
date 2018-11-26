package lettcode.Q500;

import lettcode.tree.TreeNode;

import java.util.List;

/**
 * 404. 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class Q404 {
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
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        while (root != null) {
            sum = sum + root.val;

        }
        return sum;
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
