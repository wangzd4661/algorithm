package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Path {
    private Graph G;   // 图的引用
    private int s;     // 起始点
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问
    private int[] from;         // 记录路径, from[i]表示查找的路径上i的上一个节点

    // 构造函数, 寻路算法, 寻找图graph从s点到其他点的路径
    public Path(Graph graph, int s) {

        // 算法初始化
        G = graph;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;

        // 寻路算法
        dfs(s);
    }

    // 图的深度优先遍历
    private void dfs(int v) {
        visited[v] = true;
        for (int i : G.adj(v))
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
    }

    // 查询从s点到w点是否有路径
    boolean hasPath(int w) {
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    private ArrayList<Integer> path(int w) {

        assert hasPath(w);

        LinkedList<Integer> s = new LinkedList<>();
        // 通过from数组逆向查找到从s到w的路径, 存放到栈中
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }

        // 从栈中依次取出元素, 获得顺序的从s到w的路径
        ArrayList<Integer> res = new ArrayList<>();
        while (!s.isEmpty())
            res.add(s.pop());

        return res;
    }

    // 打印出从s点到w点的路径
    void showPath(int w) {

        assert hasPath(w);

        ArrayList<Integer> list = path(w);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i == list.size() - 1)
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }
}
