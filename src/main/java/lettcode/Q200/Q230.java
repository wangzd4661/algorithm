package lettcode.Q200;

import lettcode.tree.TreeNode;

public class Q230 {
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }
    int rank=0;
    int res=0;
    public void traverse(TreeNode root,int k){
        if(root==null)return;
        traverse(root.left,k);
        rank++;
        if(rank==k){
            res=root.val;
            return ;
        }
        traverse(root.right,k);
    }
}
