package lettcode.jzoffer;

import lettcode.tree.TreeNode;

public class O54 {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    int sum=0;
    public void traverse(TreeNode root){
        if(root==null)return;
        traverse(root.right);
        sum+=root.val;
        root.val=sum;
        traverse(root.left);
    }
}
