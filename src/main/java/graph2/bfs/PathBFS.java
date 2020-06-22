package graph2.bfs;

import graph2.base.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import static graph2.base.Graph.FILE_NAME;

public class PathBFS {
    private Graph G;
    private boolean[] visited;
    private int s;
    private int t;
    private int[] pre;

    public PathBFS(Graph g, int s, int t) {
        G = g;
        this.s = s;
        this.t = t;
        pre = new int[G.V()];
        visited = new boolean[G.V()];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        bfs(s);
        for (boolean e : visited) {
            System.out.printf(e + " ");
        }
        System.out.println();
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        pre[s] = s;
        queue.add(s);
        if (s == t) return;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (Integer w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    pre[w] = v;
                    if (w == t) return;
                }
            }
        }
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
        PathBFS ss = new PathBFS(graph, 0, 1);
        System.out.println("0->1" + ss.path());
        PathBFS ss2 = new PathBFS(graph, 0, 6);
        System.out.println("0->6" + ss2.path());
    }
}
