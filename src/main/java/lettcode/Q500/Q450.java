package lettcode.Q500;

import lettcode.tree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class Q450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                TreeNode temp = root;
                temp = temp.right;
                if (temp.left != null) {
                    temp = temp.left;
                }
                root.val = temp.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
}
