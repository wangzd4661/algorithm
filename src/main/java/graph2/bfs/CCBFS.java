package graph2.bfs;

import graph2.base.Graph;
import graph2.dfs.CCDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static graph2.base.Graph.FILE_NAME;

public class CCBFS {
    private Graph G;
    private int[] visited;
    private int ccCount;

    public CCBFS(Graph g) {
        G = g;
        visited=new int[G.V()];
        for (int i = 0; i < visited.length; i++) {
            visited[i]=-1;
        }
        for (int v = 0; v < G.V(); v++) {
            if(visited[v]==-1){
                bfs(v,ccCount);
                ccCount++;
            }
        }
    }
    private void bfs(int s,int ccID) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = ccID;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (Integer w : G.adj(v)) {
                if (visited[w]==-1) {
                    queue.add(w);
                    visited[w] = ccID;
                }
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
        CCBFS ccbfs =new CCBFS(graph);
        System.out.println(ccbfs.count());
        System.out.println(ccbfs.isConnected(0,6));
        System.out.println(ccbfs.isConnected(0,5));
        System.out.println(Arrays.toString(ccbfs.components()));
    }
}
