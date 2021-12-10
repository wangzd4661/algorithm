package lettcode.Q500;

import lettcode.tree.TreeNode;

public class Q538 {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    public void traverse(TreeNode root){
        if(root==null)return;
        traverse(root.right);
        sum+=root.val;
        root.val=sum;
        traverse(root.left);
    }
}
