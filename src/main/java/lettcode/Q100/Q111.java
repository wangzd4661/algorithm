package lettcode.Q100;

import lettcode.tree.TreeNode;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class Q111 {
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

        //n3.right = n6;
        int depth = minDepth(n1);
        System.out.print(depth);
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
        } else if (root.left != null) {
            return minDepth(root.left) + 1;
        } else if (root.right != null) {
            return minDepth(root.right) + 1;
        } else {
            return 1;
        }
    }
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftDepth=minDepth(root.left);
        int rightDepth=minDepth(root.right);
        return (leftDepth == 0 || rightDepth == 0) ? leftDepth + rightDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
    }

}
