package lettcode.Q200;

import lettcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Q102 {
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


        levelOrder(n1);
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<ArrayList<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            ArrayList<Integer> inList = new ArrayList<>();
            TreeNode temp = queue.poll();
            System.out.print(temp.val + ",");
            if (temp.left != null) {
                queue.add(temp.left);
                inList.add(temp.left.val);
            }
            if (temp.right != null) {
                queue.add(temp.right);
                inList.add(temp.right.val);
            }
            list.add(inList);
        }
        System.out.println(list.toString());
    }
}
