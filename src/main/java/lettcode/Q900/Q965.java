package lettcode.Q900;

import lettcode.tree.TreeNode;

public class Q965 {
    public static void main(String[] args) {
        boolean univalTree = new Q965().isUnivalTree(null);
        System.out.println(univalTree);
    }
    //思路1，遍历二叉树，记录树的节点树count，记录总的值total，然后total/count==root.val
    //思路2，遍历二叉树，查看root.val==node.val
    public boolean isUnivalTree(TreeNode root) {
        return traverse(root,root.val);
    }
    public boolean traverse(TreeNode root,int v){
        if(root==null)return true;
        if(root.val!=v)return false;
        boolean left=traverse(root.left,v);
        boolean right=traverse(root.right,v);
        return left&&right;
    }
}
