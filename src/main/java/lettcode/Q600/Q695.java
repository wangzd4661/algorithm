package lettcode.Q600;

import java.util.HashSet;

/**
 * 695. 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class Q695 {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int R, C;
    private int[][] grid;
    private HashSet<Integer>[] G;
    private boolean[] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        R = grid.length;
        if (R == 0) return 0;
        C = grid[0].length;
        if (C == 0) return 0;
        this.grid = grid;
        G = buildGraph();
        visited = new boolean[G.length];
        int res = 0;
        for (int v = 0; v < G.length; v++) {
            int x = v / C, y = v % C;
            if (!visited[v] && grid[x][y] == 1) {
                res = Math.max(res, dfs(v));
            }
        }
        return res;
    }

    private int dfs(int v) {
        visited[v] = true;
        int res = 1;
        for (Integer w : G[v]) {
            if (!visited[w]) {
                res = res + dfs(w);
            }
        }
        return res;
    }

    private HashSet<Integer>[] buildGraph() {
        HashSet<Integer>[] g = new HashSet[R * C];
        for (int i = 0; i < g.length; i++) {
            g[i] = new HashSet<>();
        }
        for (int v = 0; v < g.length; v++) {
            int x = v / C, y = v % C;//一维到二维的转换
            if (grid[x][y] == 1) {
                for (int d = 0; d < 4; d++) {
                    int nextX = x + dirs[d][0];
                    int nextY = y + dirs[d][1];
                    if (inArea(nextX, nextY) && grid[nextX][nextY] == 1) {
                        int next = nextX * C + nextY;
                        g[v].add(next);
                        g[next].add(v);
                    }
                }
            }
        }
        return g;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}};
        System.out.println((new Q695()).maxAreaOfIsland(grid));
    }
}
