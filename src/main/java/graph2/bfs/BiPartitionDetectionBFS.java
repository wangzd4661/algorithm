package graph2.bfs;

import graph2.base.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BiPartitionDetectionBFS {
    private Graph G;

    private boolean[] visited;
    private int[] colors;
    private boolean isBipartite = true;

    public BiPartitionDetectionBFS(Graph G){

        this.G = G;
        visited = new boolean[G.V()];
        colors = new int[G.V()];
        for(int i = 0; i < G.V(); i ++)
            colors[i] = -1;

        for(int v = 0; v < G.V(); v ++)
            if(!visited[v])
                if(!bfs(v)){
                    isBipartite = false;
                    break;
                }
    }

    private boolean bfs(int s){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        colors[s] = 0;

        while(!queue.isEmpty()){
            int v = queue.remove();

            for(int w: G.adj(v))
                if(!visited[w]){
                    queue.add(w);
                    visited[w] = true;
                    colors[w] = 1 - colors[v];
                }
                else if(colors[v] == colors[w])
                    return false;
        }
        return true;
    }

    public boolean isBipartite(){
        return isBipartite;
    }

    public static void main(String[] args){

        Graph g = new Graph("src/main/java/graph2/bfs/g.txt");
        BiPartitionDetectionBFS bipartitionDetection = new BiPartitionDetectionBFS(g);
        System.out.println(bipartitionDetection.isBipartite);
        // true

        Graph g2 = new Graph("src/main/java/graph2/bfs/g2.txt");
        BiPartitionDetectionBFS bipartitionDetection2 = new BiPartitionDetectionBFS(g2);
        System.out.println(bipartitionDetection2.isBipartite);
        // false

        Graph g3 = new Graph("src/main/java/graph2/bfs/g3.txt");
        BiPartitionDetectionBFS bipartitionDetection3 = new BiPartitionDetectionBFS(g3);
        System.out.println(bipartitionDetection3.isBipartite);
        //true
    }
}