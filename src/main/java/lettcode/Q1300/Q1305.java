package lettcode.Q1300;

import lettcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1305 {
    public static void main(String[] args) {

    }
    //思路：中序遍历2个树，然后合并两个数组。
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        traverse(root1,list1);
        traverse(root2,list2);
        List<Integer> list3= new ArrayList<>(list1);
        list3.addAll(list2);
        Collections.sort(list3);
        return list3;
    }
    public void traverse(TreeNode root,List<Integer> res) {
        if (root == null) return;
        traverse(root.left,res);
        res.add(root.val);
        traverse(root.right,res);
    }
    //思路2：中序遍历，然后使用归并排序思想合并数组。
}
