package lettcode.Q100;

import lettcode.Q001.Q1;
import lettcode.tree.TreeNode;

import java.util.*;

public class Q113 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode n1=new TreeNode(4);
        TreeNode n2=new TreeNode(8);
        TreeNode n3=new TreeNode(11);
        TreeNode n4=new TreeNode(13);
        TreeNode n5=new TreeNode(4);
        TreeNode n6=new TreeNode(7);
        TreeNode n7=new TreeNode(2);
        TreeNode n8=new TreeNode(5);
        TreeNode n9=new TreeNode(1);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n1.right=null;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        n5.left=n8;
        n5.right=n9;
        List r=new Q113().pathSum(root,22);
        System.out.println(Arrays.toString(r.toArray()));
    }

    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }

}
