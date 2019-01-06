package graph;

// 求无权图的联通分量
public class Components {
    private Graph g;
    private boolean[] visited;
    private int ccount;         // 记录联通分量个数
    private int[] id;           // 每个节点所对应的联通分量标记

    public Components(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        ccount = 0;
        id = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }

    }

    // 返回图的联通分量个数
    public int count() {
        return ccount;
    }

    // 查询点v和点w是否联通
    public boolean isConnected(int v, int w) {
        assert v >= 0 && v < g.V();
        assert w >= 0 && w < g.V();
        return id[v] == id[w];
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;
        for (Integer i : g.adj(v)) {
            if (!visited[i])
                dfs(i);
        }
    }
}
