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
    public TreeNode root;

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 1, 0};
        BinarySearchTree tree = new BinarySearchTree(nums);
        TreeNode delete = tree.delete(2);
        tree.inOrder(tree.root);
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
            if (curNode.val < key) {//比当前节点大，//插入右边
                if (curNode.right == null) {//当前节点没右子树，插入此处
                    curNode.right = newNode;
                    curNode = null;
                } else {    //继续寻找
                    curNode = curNode.right;
                }
            } else if (curNode.val > key) {//比当前节点小，插入左边
                if (curNode.left == null) {//当前节点没右子树，插入此处
                    curNode.left = newNode;
                    curNode = null;
                } else { //继续寻找
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
        return delete(root, key);
    }

    /**
     * @param treeNode
     * @param key
     * @return 删除4种节点。
     */
    private TreeNode delete(TreeNode treeNode, int key) {
        if (treeNode == null) return null;
        if (treeNode.val < key) {//右子树中找到要删除节点
            treeNode.right = delete(treeNode.right, key);
        } else if (treeNode.val > key) {
            treeNode.left = delete(treeNode.left, key);
        } else if (treeNode.val == key) {//找到节点
            if (treeNode.left == null && treeNode.right == null) {//左右子树都为空
                treeNode = null;
            } else if (treeNode.left == null) {//只有右子树
                treeNode = treeNode.right;
            } else if (treeNode.right == null) {//只有左子树
                treeNode = treeNode.left;
            } else if (treeNode.left != null && treeNode.right != null) {//包含左右子树
                //找到左子树最大的节点，或者右子树最小的节点来代替当前节点
                TreeNode tmp = treeNode;
                tmp = tmp.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                treeNode.val = tmp.val;
                treeNode.left = delete(treeNode.left, treeNode.val);
            }
        }
        return treeNode;
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
