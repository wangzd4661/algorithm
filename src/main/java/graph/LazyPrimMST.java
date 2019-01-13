package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LazyPrimMST<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> G;    // 图的引用
    private PriorityQueue<Edge<Weight>> pq;   // 最小堆, 算法辅助数据结构
    private boolean[] marked;           // 标记数组, 在算法运行过程中标记节点i是否被访问
    private ArrayList<Edge<Weight>> mst;   // 最小生成树所包含的所有边
    private Number mstWeight;           // 最小生成树的权值

    public LazyPrimMST(WeightedGraph<Weight> graph) {
        G = graph;
        pq = new PriorityQueue<>();
        marked = new boolean[G.E()];
        mst = new ArrayList<>();

        // Lazy Prim
        visit(0);
        while (!pq.isEmpty()) {
            // 使用最小堆找出已经访问的边中权值最小的边
            Edge edge = pq.poll();
            // 如果这条边的两端都已经访问过了, 则扔掉这条边
            if (marked[edge.v()] == marked[edge.w()]) {
                continue;
            }
            // 否则, 这条边则应该存在在最小生成树中
            mst.add(edge);
            if (!marked[edge.v()]) {
                visit(edge.v());
            } else {
                visit(edge.w());
            }
        }
        // 计算最小生成树的权值

        mstWeight = mst.get(0).wt();
        for( int i = 1 ; i < mst.size() ; i ++ )
            mstWeight = mstWeight.doubleValue() + mst.get(i).wt().doubleValue();

    }

    //访问节点v
    private void visit(int v) {
        assert !marked[v];
        marked[v] = true;
        // 将和节点v相连接的所有未访问的边放入最小堆中
        for (Edge<Weight> edge : G.adj(v)) {
            if (!marked[edge.other(v)]) {
                pq.add(edge);
            }
        }

    }

    // 返回最小生成树的所有边
    public List<Edge<Weight>> mstEdges() {
        return mst;
    }

    // 返回最小生成树的权值
    public Number result() {
        return mstWeight;
    }

    public static void main(String[] args) {
        String filename = "src\\\\main\\\\java\\\\graph\\\\testG3.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        List<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.get(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();
    }
}
