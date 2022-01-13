package lettcode.Q900;

import lettcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q938 {
    //思路：二叉搜索树，中序遍历有序。保存所有数据，然后遍历
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> res=new ArrayList<>();
        traverse(root,res);
        int sum=0;
        for (int i = 0; i < res.size(); i++) {
            int cur=res.get(i);
            if(cur<low)continue;
            if(cur>high)break;
            sum=sum+cur;
        }
        return sum;
    }
    public void  traverse(TreeNode root, List<Integer> res){
        if(root==null)return;
        traverse(root.left,res);
        res.add(root.val);
        traverse(root.right,res);
    }
    //思路2：遍历时直接累加
    int sum=0;
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if(root==null)return 0;
        rangeSumBST2(root.left,low,high);
        rangeSumBST2(root.right,low,high);
        if(root.val>=low&&root.val<=high)sum=sum+root.val;
        return sum;
    }
    //思路3：根据条件提前终止
    public int rangeSumBST3(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
