package graph2;

import java.util.ArrayList;
import java.util.Collections;

public class SingleSourcePath {
    private Graph G;
    private boolean[] visited;
    private int s;
    private int[] pre;

    public SingleSourcePath(Graph g,int s) {
        G = g;
        this.s=s;
        pre=new int[G.V()];
        visited=new boolean[G.V()];
        for (int i = 0; i <pre.length ; i++) {
            pre[i]=-1;
        }
        dfs(s,s);
    }
    private void dfs(int v,int parent){
        visited[v]=true;
        pre[v]=parent;
        for (Integer w : G.adj(v)) {
            if(!visited[w]){
                dfs(w,v);
            }
        }
    }
    public boolean isConnectedTo(int t){
        G.validateVertex(t);
        return visited[t];
    }
    public Iterable<Integer> path(int t){
        ArrayList<Integer> res=new ArrayList<>();
        if(!isConnectedTo(t))return res;
        int cur=t;
        while (cur!=s){
            res.add(cur);
            cur=pre[cur];
        }
        res.add(s);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("src/main/java/graph2/g.txt");
        SingleSourcePath ss=new SingleSourcePath(graph,0);
        System.out.println(ss.path(6));
    }
}
