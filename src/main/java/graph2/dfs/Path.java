package graph2.dfs;

import graph2.base.Graph;

import java.util.ArrayList;
import java.util.Collections;

import static graph2.base.Graph.FILE_NAME;

/**
 * 提前返回，不用遍历整张图
 */
public class Path {
    private Graph G;
    private boolean[] visited;
    private int s;
    private int t;
    private int[] pre;

    public Path(Graph g, int s, int t) {
        G = g;
        this.s = s;
        this.t = t;
        pre = new int[G.V()];
        visited = new boolean[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        dfs(s, s);
        for (boolean e : visited) {
            System.out.printf(e + " ");
        }
        System.out.println();
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        pre[v] = parent;
        if (v == t) return true;
        for (Integer w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) return true;
            }
        }
        return false;
    }

    public boolean isConnected() {
        return visited[t];
    }

    public Iterable<Integer> path() {
        ArrayList<Integer> res = new ArrayList<>();
        if (!isConnected()) return res;
        int cur = t;
        while (cur != s) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(FILE_NAME);
        Path ss = new Path(graph, 0, 1);
        System.out.println("0->1" + ss.path());
        Path ss2 = new Path(graph, 0, 6);
        System.out.println("0->6" + ss2.path());
    }
}
