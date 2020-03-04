package lettcode.Q500;

import lettcode.tree.Node;

import java.util.ArrayList;
import java.util.List;
/**
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class Q590 {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(2, null));
        nodes.add(new Node(3, null));
        nodes.add(new Node(4, null));

        Node n1 = new Node(1, nodes);
        List<Integer> list = postorders(n1);
        System.out.print(list.toString());
    }

    public static List<Integer> postorders(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public static void postorder(Node root, List list) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                postorder(child, list);
            }
        }
        list.add(root.val);
    }
}
