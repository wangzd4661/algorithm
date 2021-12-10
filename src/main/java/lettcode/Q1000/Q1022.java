package lettcode.Q1000;

import lettcode.tree.TreeNode;

public class Q1022 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;

        System.out.print(new Q1022().sumRootToLeaf(n1));
    }
    public int sumRootToLeaf(TreeNode root) {
        traverse(root,"");
        return sum;
    }
    int sum=0;
    public void traverse(TreeNode root,String bit){
        if(root==null)return;
        bit=bit+root.val;
        if(root.left==null&&root.right==null){
            sum+=Integer.parseInt(bit,2);
        }else {
            traverse(root.left,bit);
            traverse(root.right,bit);
        }
    }
}
