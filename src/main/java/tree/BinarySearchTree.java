package tree;

/**
 * 二叉查找树（二叉搜索树、有序二叉树或排序二叉树）
 * 查找、插入的时间复杂度O(logN)
 * <p>
 * 是指一棵空树或者具有下列性质的二叉树：
 * <p>
 * 1.若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * 2.若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 3.任意节点的左、右子树也分别为二叉查找树；
 * 4.没有键值相等的节点。
 */
public class BinarySearchTree {
    public static TreeNode root;

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 1, 0};
        BinarySearchTree tree = new BinarySearchTree(nums);
        tree.inOrder(root);
        TreeNode treeNode = tree.search(4);
        if (treeNode != null) {
            System.out.println(treeNode.val);
        } else {
            System.out.println("null");
        }
        tree.delete(0);
        tree.inOrder(root);

    }

    public BinarySearchTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public TreeNode insert(int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) {
            root = newNode;
            return newNode;
        }
        TreeNode curNode = root;
        while (curNode != null) {
            if (curNode.val < key) {
                if (curNode.right == null) {
                    curNode.right = newNode;
                    curNode = null;
                } else {
                    curNode = curNode.right;
                }
            } else if (curNode.val > key) {
                if (curNode.left == null) {
                    curNode.left = newNode;
                    curNode = null;
                } else {
                    curNode = curNode.left;
                }
            }
        }
        return newNode;
    }

    public TreeNode search(int key) {
        return search(root, key);
    }

    private TreeNode search(TreeNode treeNode, int key) {
        if (treeNode == null) return null;
        if (treeNode.val == key) {
            return treeNode;
        } else if (treeNode.val < key) {
            return search(treeNode.right, key);
        } else if (treeNode.val > key) {
            return search(treeNode.left, key);
        }
        return null;
    }

    public TreeNode delete(int key) {
        return delete(root, root, key);
    }

    private TreeNode delete(TreeNode parNode, TreeNode treeNode, int key) {
        TreeNode result = null;
        if (treeNode == null) {
            return result;
        }
        if (treeNode.val < key) {
            return delete(treeNode, treeNode.right, key);
        } else if (treeNode.val > key) {
            return delete(treeNode, treeNode.left, key);
        } else {//找到节点
            //左右节点都为空
            if (treeNode.left == null && treeNode.right == null) {
                result = treeNode;
                treeNode = null;
            } else if (treeNode.left != null && treeNode.right == null) {//只有左子树
                if (parNode.left == treeNode) {
                    parNode.left = treeNode.left;
                } else if (parNode.right == treeNode) {
                    parNode.right = treeNode.left;
                }
                result = treeNode;
                treeNode = null;
            } else if (treeNode.left == null && treeNode.right != null) {//只有右子树
                if (parNode.left == treeNode) {
                    parNode.left = treeNode.right;
                } else if (parNode.right == treeNode) {
                    parNode.right = treeNode.right;
                }
                result = treeNode;
                treeNode = null;
            } else if (treeNode.left == null && treeNode.right == null) {//包含左右子树

            }
        }
        return result;
    }

    /**
     * 在左子树中找到最大值
     *
     * @param treeNode
     * @return
     */
    private TreeNode findMaxInLeftTree(TreeNode treeNode) {
        return null;
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
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
