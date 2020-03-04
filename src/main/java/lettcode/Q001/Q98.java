package lettcode.Q001;

import lettcode.tree.TreeNode;

import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Q98 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;
        //n2.left = n4;
       // n2.right = n5;
        //n3.left = n6;
        System.out.print(isValidBST2(n1));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> stack = new LinkedList();
        TreeNode treeNode = root;
        int pre = 0;
        boolean first = true;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.val + ",");
                if (first) {
                    pre = treeNode.val;
                    first = false;
                } else {
                    if (treeNode.val <= pre) {
                        return false;
                    }
                    pre = treeNode.val;
                }
                treeNode = treeNode.right;
            }
        }
        return true;
    }
    public static boolean isValidBST2(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean valid(TreeNode root, long low, long high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }

}
