package lettcode.Q1300;

import lettcode.tree.TreeNode;

public class Q1373 {
    int max=0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return max;
    }
    //res[0] 记录以 root 为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
    //res[1] 记录以 root 为根的二叉树所有节点中的最小值；
    //res[2] 记录以 root 为根的二叉树所有节点中的最大值；
    //res[3] 记录以 root 为根的二叉树所有节点值之和。
    public int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] res = new int[4];
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        //左子树为BST，右子树为BST，加上自己还为BST
        if (left[0] == 1 && right[0] == 1 &&
                root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(left[1], root.val);
            res[2] = Math.max(right[2], root.val);
            res[3] = root.val + left[3] + right[3];
            max=Math.max(max,res[3]);
        } else {
            res[0]=0;
        }
        return res;
    }
}
