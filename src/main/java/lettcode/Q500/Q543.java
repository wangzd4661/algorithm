package lettcode.Q500;

import lettcode.tree.TreeNode;

public class Q543 {
    public static void main(String[] args) {

    }
    private int ans=1;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans-1;
    }
    public int depth(TreeNode root) {
        if(root==null)return 0;
        int l=depth(root.left);
        int r=depth(root.right);
        ans=Math.max(ans,l+r+1);
        return Math.max(l,r)+1;
    }
}
