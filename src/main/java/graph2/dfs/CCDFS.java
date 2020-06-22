package graph2.dfs;

import graph2.base.Graph;

import java.util.ArrayList;
import java.util.Arrays;

import static graph2.base.Graph.FILE_NAME;

/**
 * 无向图联通分量
 */
public class CCDFS {
    private Graph G;
    private int[] visited;
    private int ccCount;

    public CCDFS(Graph g) {
        G = g;
        visited=new int[G.V()];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=-1;
        }
        for (int v = 0; v < G.V(); v++) {
            if(visited[v]==-1){
                dfs(v,ccCount);
                ccCount++;
            }
        }
    }
    private void dfs(int v,int ccID){
        visited[v]=ccID;
        for (Integer w : G.adj(v)) {
            if(visited[w]==-1){
                dfs(w,ccID);
            }
        }
    }
    public int count(){
        for (int e : visited) {
            System.out.printf(e+" ");
        }
        System.out.println();
        return ccCount;
    }
    public boolean isConnected(int v,int w){
        G.validateVertex(v);
        G.validateVertex(w);
        return visited[v]==visited[w];
    }
    public ArrayList<Integer>[] components(){
         ArrayList<Integer>[] res= new ArrayList[ccCount];
        for (int i = 0; i < ccCount; i++) {
            res[i]=new ArrayList<>();
        }
        for (int v = 0; v < G.V(); v++) {
            res[visited[v]].add(v);
        }
        return res;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(FILE_NAME);
        CCDFS CCDFS =new CCDFS(graph);
        System.out.println(CCDFS.count());
        System.out.println(CCDFS.isConnected(0,6));
        System.out.println(CCDFS.isConnected(0,5));
        System.out.println(Arrays.toString(CCDFS.components()));
    }
}
