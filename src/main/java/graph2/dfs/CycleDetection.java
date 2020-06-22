package graph2.dfs;

import graph2.base.Graph;

/**
 * 环检测
 */
public class CycleDetection {
    private Graph G;
    private boolean[] visited;
    private boolean hasCycle = false;

    public CycleDetection(Graph g) {
        G = g;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                if (dfs(v, v)) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v, int parent) {
        visited[v] = true;
        for (Integer w : G.adj(v)) {
            if (!visited[w]) {
                if (dfs(w, v)) return true;
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("src/main/java/graph2/dfs/g2.txt");
        CycleDetection cycleDetection = new CycleDetection(graph);
        System.out.println(cycleDetection.hasCycle());
    }
}
