package tree;

/**
 * AVL 树是一种平衡二叉查找树
 * 平衡二叉树递归定义如下：
 * 1.左右子树的高度差小于等于 1。
 * 2.其每一个子树均为平衡二叉树。
 */
public class AVLTree {
    public TreeNode root;

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 1, 0};
        AVLTree avlTree = new AVLTree(nums);
        avlTree.inOrder(avlTree.root);

    }

    public AVLTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            TreeNode treeNode = insert(root, nums[i]);
            System.out.printf(treeNode.val + "");
        }
    }

    private TreeNode insert(TreeNode treeNode, int key) {
        if (treeNode == null) {
            TreeNode newNode = new TreeNode(key);
            if (root == null) {
                root = newNode;
            }
            return newNode;
        }
        if (treeNode.val == key) {
            return null;
        } else if (treeNode.val > key) {
            treeNode.left = insert(treeNode.left, key);
        } else if (treeNode.val < key) {
            treeNode.right = insert(treeNode.right, key);
        }
        treeReBalance(root);
        return treeNode;
    }

    /**
     * 平衡操作
     *
     * @param
     */
    private TreeNode treeReBalance(TreeNode treeNode) {
        if (treeNode == null) {
            return treeNode;
        }
        return treeNode;
    }

    private int height(TreeNode tree) {
        if (tree != null)
            return tree.height;
        return 0;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + ",");
        inOrder(root.right);
    }


    public static class TreeNode {
        int val;
        int height;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
