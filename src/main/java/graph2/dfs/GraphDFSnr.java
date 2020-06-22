package graph2.dfs;
import graph2.base.Graph;

import java.util.ArrayList;
import java.util.Stack;

import static graph2.base.Graph.FILE_NAME;

//DFS非递归实现
public class GraphDFSnr {
    private Graph G;
    private ArrayList<Integer> pre = new ArrayList<>();
    private boolean[] visited;

    public GraphDFSnr(Graph g) {
        G = g;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        while(!stack.empty()){
            int cur = stack.pop();
            pre.add(cur);
            for(int w: G.adj(v))
                if(!visited[w]){
                    stack.push(w);
                    visited[w] = true;
                }
        }
    }

    public Iterable<Integer> pre() {
        return pre;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(FILE_NAME);
        GraphDFSnr graphDFSnr = new GraphDFSnr(graph);
        System.out.println(graphDFSnr.pre());
    }
}
