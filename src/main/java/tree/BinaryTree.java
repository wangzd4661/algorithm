package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/***
 *         1
 *        / \
 *     2     3
 *   /  \     \
 *  4   5      6
 */
public class BinaryTree {
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


        int s = depth(n1);
        System.out.printf("" + s);
    }

    /**
     * 前序遍历 DLR
     *
     * @param root 1,2,4,5,3,6,
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ",");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历 LDR
     *
     * @param root 4,2,5,1,3,6,
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + ",");
        inOrder(root.right);
    }

    /**
     * 后序遍历 LRD
     *
     * @param root 4,5,2,6,3,1,
     */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + ",");
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + ",");
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }

    /**
     * 获取节点数
     *
     * @param root
     * @return
     */
    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    /**
     * 节点深度
     *
     * @param root
     * @return
     */
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
