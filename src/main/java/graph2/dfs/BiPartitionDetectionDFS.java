package graph2.dfs;

import graph2.base.Graph;

import static graph2.base.Graph.FILE_NAME;

/**
 * 二分图检测
 */
public class BiPartitionDetectionDFS {
    private Graph G;
    private boolean[] visited;
    private boolean biPart = true;
    private int[] colors;

    public BiPartitionDetectionDFS(Graph g) {
        G = g;
        visited = new boolean[G.V()];
        colors = new int[G.V()];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = -1;
        }
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                if (!dfs(v, 0)) {
                    biPart = false;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (Integer w : G.adj(v)) {
            if (!visited[w]) {
                if (!dfs(w, 1-color)) return false;
            } else if (colors[w] == colors[v]) return false;
        }
        return true;
    }

    public boolean isBipartite() {
        return biPart;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(FILE_NAME);
        BiPartitionDetectionDFS biPartitionDetection = new BiPartitionDetectionDFS(graph);
        System.out.println(biPartitionDetection.isBipartite());

        Graph graph2 = new Graph("src/main/java/graph2/g3.txt");
        BiPartitionDetectionDFS biPartitionDetection2 = new BiPartitionDetectionDFS(graph2);
        System.out.println(biPartitionDetection2.isBipartite());
    }
}

