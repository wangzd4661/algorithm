package graph2.dfs;

import graph2.base.Graph;

import static graph2.base.Graph.FILE_NAME;

/**
 * 所有路径
 */
public class AllPairsPathDFS {
    private Graph G;
    private SingleSourcePathDFS[] paths;

    public AllPairsPathDFS(Graph g) {
        G = g;
        paths = new SingleSourcePathDFS[G.V()];
        for (int v = 0; v < paths.length; v++) {
            paths[v] = new SingleSourcePathDFS(G, v);
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
        AllPairsPathDFS allPairsPathDFS = new AllPairsPathDFS(graph);
        System.out.println(allPairsPathDFS.path(0, 6));
    }
}
