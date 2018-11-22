package lettcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class Q515 {
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
        List list = largestValues(n1);
        System.out.print(list.toString());
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        //list.add(largest(root));
        return list;
    }

    public static void largest(TreeNode root, List list) {
        if (root == null) return;
        int max = Math.max(root.left.val, root.right.val);
        list.add(max);
    }


    /**
     * LDR
     *
     * @param root
     */
    public static void inOrder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}
