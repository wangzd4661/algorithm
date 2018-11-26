package lettcode.Q200;

import lettcode.tree.TreeNode;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Q101 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;

      /*  n2.left = n4;
        n2.right = n5;

        n3.right = n6;*/

        System.out.print(isSymmetric(n1));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        return (left.val == right.val)&& isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
