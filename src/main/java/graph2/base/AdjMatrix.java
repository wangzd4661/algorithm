package graph2.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static graph2.base.Graph.FILE_NAME;

/**
 * 矩阵实现
 * 查看两点是否相邻O（1）
 * 建图 O（E）
 * 缺点：空间复杂度高O（V^2）
 * 缺点：求一点的相邻节点O（V）
 */
public class AdjMatrix {
    private int V;
    private int E;
    private int[][] adj;
    public AdjMatrix(String fileName){
        if(fileName==null||fileName.isEmpty()){
            throw new IllegalArgumentException("fileName must be non-null");
        }
        File file=new File(fileName);
        try (Scanner scanner= new Scanner(file)){
            V=scanner.nextInt();
            if(V<0)throw new IllegalArgumentException("V must be non-negative");
            adj=new int[V][V];
            E=scanner.nextInt();
            if(E<0)throw new IllegalArgumentException("E must be non-negative");
            for (int i = 0; i < E; i++) {
                int a=scanner.nextInt();
                validateVertex(a);
                int b=scanner.nextInt();
                validateVertex(b);
                if(a==b)throw new IllegalArgumentException("Self Loop is invalid");
                if(adj[a][b]==1)throw new IllegalArgumentException("Parallel Edges is invalid");
                adj[a][b]=1;
                adj[b][a]=1;
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void validateVertex(int v){
        if(v<0||v>=V)throw new IllegalArgumentException("vertex "+v+"is invalid");
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public boolean hasEdge(int v,int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v][w]==1;
    }
    public ArrayList<Integer> adj(int v){
        validateVertex(v);
        ArrayList<Integer> res=new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if(adj[v][i]==1){
                res.add(i);
            }
        }
        return res;
    }
    public int degree(int v){
        return adj(v).size();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("V=%d,E=%d",V,E));
        sb.append("\n");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                sb.append(String.format("%d ",adj[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix=new AdjMatrix(FILE_NAME);
        System.out.println(adjMatrix);
    }
}
