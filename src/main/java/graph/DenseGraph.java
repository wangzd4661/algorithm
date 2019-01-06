package graph;

import java.util.ArrayList;

// 稠密图 - 邻接矩阵
public class DenseGraph implements Graph{
    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;   // 是否为有向图
    private boolean[][] g;      // 图的具体数据

    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
    }

    // 返回节点个数
    @Override
    public int V() {
        return n;
    }

    // 返回边的个数
    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        if (hasEdge(v, w)) return;
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (g[v][i] == true) {
                list.add(i);
            }
        }
        return list;
    }

}
