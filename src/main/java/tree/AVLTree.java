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
        int[] nums = {2,3,4,5,1};
        AVLTree avlTree = new AVLTree(nums);
        avlTree.preOrder(avlTree.root);

    }

    public AVLTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            TreeNode treeNode = insert(root, nums[i]);
        }
        //treeReBalance(root);
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
        return treeNode;
    }

    /**
     * 平衡操作
     *
     * @param
     */
    private TreeNode treeReBalance(TreeNode root) {
        int factor = getBalanceFactor(root);
        if (factor > 1 && getBalanceFactor(root.left) > 0) {//LL
            return rorateRight(root);
        } else if (factor > 1 && getBalanceFactor(root.left) <= 0) {//LR
            root.left = rorateLeft(root.left);
            return rorateRight(root);
        } else if (factor < -1 && getBalanceFactor(root.right) <= 0) {//RR
            return rorateLeft(root);
        } else if (factor < -1 && getBalanceFactor(root.right) > 0) {//RL
            root.right = rorateRight(root.right);
            return rorateLeft(root);
        } else {
            return root;
        }
    }

    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
        }
    }

    /**
     *      D3
     *     /
     *    C1            C1
     *   /  \          /   \
     *  A0   B2       A0   D3
     *                     /
     *                    B2
     */
    /**
     * @param root
     * @return 右旋
     */
    private TreeNode rorateRight(TreeNode root) {
        TreeNode left = root.left;  //C1
        root.left = left.right;  //把左边节点（C1）的右子树（B2）赋值给根节点（D3）的左子树
        left.right = root; //调换父子关系（D3变为C1的右子树）
        left.height = treeHeight(left);
        root.height = treeHeight(root);
        return left;

    }
    /**
     *      D0
     *       \
     *       C2           C2
     *      /  \        /   \
     *     A1   B3     D0   B3
     *                  \
     *                  A1
     */
    /**
     * @param root 要调整的根节点
     * @return 返回调整好的根节点
     * 左旋
     */
    private TreeNode rorateLeft(TreeNode root) {
        TreeNode right = root.right;  //C2
        root.right = right.left;  //把右边节点（C2）的左子树（A1）赋值给根节点（D0）的右子树
        right.left = root; //调换父子关系（D0变为C2的左子树）
        right.height = treeHeight(right);
        root.height = treeHeight(root);
        return right;

    }

    private int getBalanceFactor(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return root.left.height - root.right.height;
        }
    }

    public  void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ",");
        preOrder(root.left);
        preOrder(root.right);
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
