package graph2;

import java.util.ArrayList;

/**
 * 时间复杂度O（V+E）
 */
public class GraphDFS {
    private Graph G;
    private ArrayList<Integer> pre=new ArrayList<>();
    private ArrayList<Integer> post=new ArrayList<>();
    private boolean[] visited;

    public GraphDFS(Graph g) {
        G = g;
        visited=new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if(!visited[v]){
                dfs(v);
            }
        }
    }
    private void dfs(int v){
        visited[v]=true;
        pre.add(v);
        for (Integer w : G.adj(v)) {
            if(!visited[w]){
                dfs(w);
            }
        }
        post.add(v);
    }
    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("src/main/java/graph2/g.txt");
        GraphDFS graphDFS=new GraphDFS(graph);
        System.out.println(graphDFS.pre());
        System.out.println(graphDFS.post());
    }
}
