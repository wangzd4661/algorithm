package lettcode.Q200;

import lettcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {

    public static List<String> binaryTreePaths(TreeNode root) {
        List list = new ArrayList<String>();
        binaryTreePaths(root,"",list);
        return list;
    }

    public static void binaryTreePaths(TreeNode node, String path, List<String> paths) {
        if (node == null) return;
        path = path + node.val;
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            path = path + "->";
            binaryTreePaths(node.left, path, paths);
            binaryTreePaths(node.right, path, paths);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        for (String binaryTreePath : binaryTreePaths(root)) {
            System.out.println(binaryTreePath);
        }

    }
}
