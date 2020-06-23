package lettcode.Q1000;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 */
public class Q1091 {
    private int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1},
            {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    private boolean[][] visited;
    private int R, C;
    private int dis[][];

    public int shortestPathBinaryMatrix(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        visited = new boolean[R][C];
        dis = new int[R][C];
        if (grid[0][0] == 1) return -1;//不通
        if (R == 1 && C == 1) return 1;//只有一个
        //bfs
        Queue<Integer> queue = new LinkedList<>();
        visited[0][0] = true;
        dis[0][0] = 1;
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int curX = cur / C, curY = cur % C;
            for (int d = 0; d < 8; d++) {
                int nextX = curX + dirs[d][0], nextY = curY + dirs[d][1];
                if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                    int next = nextX * C + nextY;
                    visited[nextX][nextY] = true;
                    queue.add(next);
                    dis[nextX][nextY] = dis[curX][curY] + 1;
                    if (nextX == R - 1 && nextY == C - 1) {
                        return dis[nextX][nextY];
                    }
                }
            }
        }
        return -1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
