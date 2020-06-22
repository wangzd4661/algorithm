package graph2.dfs;

import graph2.base.Graph;

import static graph2.base.Graph.FILE_NAME;

/**
 * 所有路径
 */
public class AllPairsPath {
    private Graph G;
    private SingleSourcePath[] paths;

    public AllPairsPath(Graph g) {
        G = g;
        paths = new SingleSourcePath[G.V()];
        for (int v = 0; v < paths.length; v++) {
            paths[v] = new SingleSourcePath(G, v);
        }
    }

    public boolean isConnectedTo(int s, int t) {
        G.validateVertex(s);
        return paths[s].isConnectedTo(t);
    }

    public Iterable<Integer> path(int s, int t) {
        G.validateVertex(s);
        return paths[s].path(t);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(FILE_NAME);
        AllPairsPath allPairsPath = new AllPairsPath(graph);
        System.out.println(allPairsPath.path(0, 6));
    }
}
