package lettcode.Q600;

import lettcode.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q652 {
    // 记录所有子树以及出现的次数
    HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();
    public  List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }
    private String traverse(TreeNode root) {
        if(root==null)return "#";
        String left=traverse(root.left);
        String right=traverse(root.right);
        String subTree=root.val+","+left+","+right;

        int freq=memo.getOrDefault(subTree,0);
        if(freq==1){
            res.add(root);
        }
        memo.put(subTree,freq+1);
        return subTree;
    }
}
