package lettcode.Q700;

/**
 * 785. 判断二分图
 * https://leetcode-cn.com/problems/is-graph-bipartite/
 */
public class Q785 {
    public static void main(String[] args) {
        int [][] a=new int[5][4];
        System.out.println(a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
        }
    }

    private boolean[] visited;
    private int[] colors;
    private int[][] g;

    public boolean isBipartite(int[][] graph) {
        g = graph;
        int V=graph.length;
        visited = new boolean[V];
        colors = new int[V];
        for (int i = 0; i < graph.length; i++) {
            colors[i] = -1;
        }
        for (int v = 0; v < V; v++) {
            if(!visited[v])
                if(!dfs(v,0))return false;
        }
        return true;
    }

    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (int w : g[v]) {
            if (!visited[w]) {
                if (!dfs(w, 1 - color)) return false;
            } else if (colors[v] == colors[w]) return false;
        }
        return true;
    }
}
