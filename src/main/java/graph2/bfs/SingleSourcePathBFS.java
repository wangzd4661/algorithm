package graph2.bfs;

import graph2.base.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import static graph2.base.Graph.FILE_NAME;

public class SingleSourcePathBFS {
    private Graph G;
    private boolean[] visited;
    private int s;
    private int[] pre;

    public SingleSourcePathBFS(Graph g, int s) {
        G = g;
        this.s = s;
        pre = new int[G.V()];
        visited = new boolean[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        bfs(s);
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        pre[s] = s;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (Integer w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    pre[w] = v;
                }
            }
        }
    }

    public boolean isConnectedTo(int t) {
        G.validateVertex(t);
        return visited[t];
    }

    public Iterable<Integer> path(int t) {
        ArrayList<Integer> res = new ArrayList<>();
        if (!isConnectedTo(t)) return res;
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
        SingleSourcePathBFS ss = new SingleSourcePathBFS(graph, 0);
        System.out.println(ss.path(6));
    }
}
