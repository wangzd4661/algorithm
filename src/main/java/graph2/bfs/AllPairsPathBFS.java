package graph2.bfs;

import graph2.base.Graph;

import static graph2.base.Graph.FILE_NAME;

public class AllPairsPathBFS {
    private Graph G;
    private SingleSourcePathBFS[] paths;

    public AllPairsPathBFS(Graph g) {
        G = g;
        paths = new SingleSourcePathBFS[G.V()];
        for (int v = 0; v < paths.length; v++) {
            paths[v] = new SingleSourcePathBFS(G, v);
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
        AllPairsPathBFS allPairsPathDFS = new AllPairsPathBFS(graph);
        System.out.println(allPairsPathDFS.path(0, 6));
    }

}
