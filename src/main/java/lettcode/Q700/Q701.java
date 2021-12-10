package lettcode.Q700;

import lettcode.tree.TreeNode;

public class Q701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)return new TreeNode(val);
        if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }else if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }
        return root;
    }
}
