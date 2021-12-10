package lettcode.Q400;

import lettcode.tree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class Q450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left != null && root.right != null) {
                TreeNode temp = root;
                temp = temp.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                root.val = temp.val;
                root.right = deleteNode(root.right, root.val);
            } else {
                root = root.left != null ? root.left : root.right;
            }
        }
        return root;
    }
    //方法一直接替换了val，不太安全。可以直接替换节点
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left != null && root.right != null) {
                TreeNode minNode = root.right;
                //找到右子树中的最小值，来当作root节点。
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                root.right=deleteNode(root.right,minNode.val);
                minNode.left=root.left;
                minNode.right=root.right;
                root=minNode;
            } else {
                root = root.left != null ? root.left : root.right;
            }
        }
        return root;
    }
}
