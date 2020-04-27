package lettcode.Q200;

import lettcode.tree.TreeNode;

public class Q235 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p.val<root.val&&q.val<root.val)return lowestCommonAncestor(root.left,p,q);
        if(p.val>root.val&&q.val>root.val)return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
