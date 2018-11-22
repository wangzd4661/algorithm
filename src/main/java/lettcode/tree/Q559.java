package lettcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 559. N叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class Q559 {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(2, null));
        nodes.add(new Node(3, null));
        nodes.add(new Node(4, null));

        Node n1 = new Node(1, nodes);
        System.out.print(maxDepth(n1));
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                depth=maxDepth(child);
            }
        }
        return depth+1;
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
