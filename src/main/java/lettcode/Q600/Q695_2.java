package lettcode.Q600;

/**
 * 695. 岛屿的最大面积
 * FloodFill
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class Q695_2 {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int R, C;
    private int[][] grid;
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        R = grid.length;
        if (R == 0) return 0;
        C = grid[0].length;
        if (C == 0) return 0;
        this.grid = grid;
        visited = new boolean[R][C];
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int x, int y) {
        visited[x][y] = true;
        int res = 1;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dirs[d][0], nextY = y + dirs[d][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                res = res + dfs(nextX, nextY);
            }
        }
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}};
        System.out.println((new Q695()).maxAreaOfIsland(grid));
    }
}
