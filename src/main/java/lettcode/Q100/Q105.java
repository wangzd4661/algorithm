package lettcode.Q100;

import lettcode.tree.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Q105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder, int preStart,int preEnd,
                          int[] inorder, int inStart,int inEnd){
        if (preStart > preEnd) {
            return null;
        }
        int rootVal=preorder[preStart];
        int index=0;
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root=new TreeNode(rootVal);
        root.left=build(preorder,preStart+1,preStart+leftSize,
                inorder,inStart,index-1);

        root.right=build(preorder,preStart+leftSize+1,preEnd,
                inorder,index+1,inEnd);
        return root;
    }
}
