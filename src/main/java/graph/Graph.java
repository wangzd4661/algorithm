package graph;

public interface Graph {
    int V();//顶点个数

    int E();//边数

    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Integer> adj(int v); //顶点的所有边
}
