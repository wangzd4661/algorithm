package lettcode.Q700;

import lettcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 654. 最大二叉树
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class Q654 {
    public static void main(String[] args) {
        int[] n = {3, 2, 1, 6, 0, 5};
        preOrder(constructMaximumBinaryTree(n));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int max = 0;
        int loc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                loc = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, loc));
        if (loc + 1 <= nums.length) {
            node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, loc + 1, nums.length));
        }
        return node;
    }
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ",");
        preOrder(root.left);
        preOrder(root.right);
    }
}
