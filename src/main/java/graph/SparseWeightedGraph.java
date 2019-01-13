package graph;

import java.util.ArrayList;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
    private int n;
    private int m;
    private boolean directed;
    private ArrayList<Edge>[] g;

    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge e) {
        assert e.v() >= 0 && e.v() < n;
        assert e.w() >= 0 && e.w() < n;
        if (hasEdge(e.v(), e.w())) return;
        g[e.v()].add(new Edge(e));
        if (directed) {
            g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));
        }
        m++;

    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i).other(v) == w) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < g[i].size(); j++) {
                Edge edge = g[i].get(j);
                System.out.print("( to:" + edge.other(i) + ",wt:" + edge.wt() + ")\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
