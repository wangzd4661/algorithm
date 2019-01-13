package graph;

public interface WeightedGraph<Weight extends Number & Comparable> {
    int V();//顶点个数

    int E();//边数

    void addEdge(Edge<Weight> e);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Edge<Weight>> adj(int v);
}
