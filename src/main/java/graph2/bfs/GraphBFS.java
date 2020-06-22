package graph2.bfs;

import graph2.base.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 时间复杂度O（V+E）
 */
import static graph2.base.Graph.FILE_NAME;

public class GraphBFS {
    private Graph G;
    private ArrayList<Integer> order = new ArrayList<>();
    private boolean[] visited;

    public GraphBFS(Graph g) {
        G = g;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                bfs(v);
            }
        }
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            order.add(v);
            for (Integer w : G.adj(v)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(FILE_NAME);
        GraphBFS graphBFS = new GraphBFS(graph);
        System.out.println(graphBFS.order());
    }
}
