package lettcode.tree;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class Q700 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;

      /*  n2.left = n4;
        n2.right = n5;

        n3.right = n6;*/
        TreeNode node = searchBST(n1, 3);
        if (node == null) {
            System.out.print("null");
        } else {
            System.out.print(node.val);
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else  {
            return searchBST(root.left, val);
        }
    }
}
