package lettcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class Q589 {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(2, null));
        nodes.add(new Node(3, null));
        nodes.add(new Node(4, null));

        Node n1 = new Node(1, nodes);
        List<Integer> list =preorders(n1);
        System.out.print(list.toString());
    }

    public static List<Integer> preorders(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public static void preOrder(Node root, List list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preOrder(child, list);
            }
        }
    }
}
