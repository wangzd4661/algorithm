package lettcode.Q500;

import lettcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class Q515 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        List list = largestValues(n1);
        System.out.print(list.toString());
    }
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null)return res;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz=queue.size();
            int max=Integer.MIN_VALUE;
            for (int i=0;i<sz;i++){
                TreeNode cur=queue.poll();
                max=Math.max(cur.val,max);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(max);
        }
        return res;
    }



    /**
     * LDR
     *
     * @param root
     */
    public static void inOrder(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}
