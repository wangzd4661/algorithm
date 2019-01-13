package graph;

import java.util.ArrayList;

public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
    private int n;//节点数
    private int m;//边数
    private boolean directed;//是否为有向图
    private Edge<Weight>[][] g;//图的数据

    public DenseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
        }
    }

    @Override
    public int V() {//节点数
        return n;
    }

    @Override
    public int E() {//边数
        return m;
    }

    @Override
    public void addEdge(Edge e) {
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;
        if (hasEdge(e.v(), e.w())) return;
        g[e.v()][e.w()] = new Edge(e);
        if (directed) {
            g[e.w()][e.v()] = new Edge(e.w(), e.v(), e.wt());
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {//v-w是否有边
        assert v >= 0 && v > n;
        assert w >= 0 && w > n;
        return g[v][w] != null;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (g[i][j] != null)
                    System.out.print(g[i][j].wt() + "\t");
                else
                    System.out.print("NULL\t");
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge> adj(int v) {
        assert v >= 0 && v < n;
        ArrayList<Edge> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (g[v][i] != null) {
                list.add(g[v][i]);
            }
        }
        return list;
    }
}
