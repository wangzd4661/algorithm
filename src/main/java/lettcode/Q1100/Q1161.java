package lettcode.Q1100;

import lettcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q1161 {
    public int maxLevelSum(TreeNode root) {
        if (root==null)return 0;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int max=Integer.MIN_VALUE,level=0,maxLevel=0;
        while (!queue.isEmpty()){
            int curSize=queue.size();
            int levelSum=0;
            for (int i = 0; i < curSize; i++) {
                TreeNode cur=queue.poll();
                if(cur.left!=null)queue.add(cur.left);
                if(cur.right!=null)queue.add(cur.right);
                levelSum+=cur.val;
            }
            level++;
            if(levelSum>max){
                max=levelSum;
                maxLevel=level;
            }
        }
        return maxLevel;
    }
}
