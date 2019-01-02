package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 邻接矩阵表示的无向图
 * Matrix Undirected Graph
 */
public class MatrixUDG {
    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'E', 'G'},
                {'F', 'G'}};
        MatrixUDG pG;

        // 采用已有的"图"
        pG = new MatrixUDG(vexs, edges);

        pG.print();   // 打印图
        pG.DFS();     // 深度优先遍历
        pG.BFS();     // 广度优先遍历
    }

    private void BFS() {
        boolean[] visited = new boolean[mVexs.length]; // 顶点访问标记
        Queue queue = new ArrayDeque();
        System.out.printf("BFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.printf("" + mVexs[i]);
                queue.add(mVexs[i]);
                while (!queue.isEmpty()) {
                    char c = (char) queue.poll();
                    for (int j = 0; j < mVexs.length; j++) {
                        if (mMatrix[i][j] == 1 && !visited[j]) {
                            visited[j] = true;
                            System.out.printf("" + mVexs[j]);
                        }
                    }
                }
            }
        }
    }

    /**
     * 深度优先搜索遍历图
     */
    private void DFS() {
        boolean[] visited = new boolean[mVexs.length]; // 顶点访问标记
        System.out.printf("DFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
    }

    private void DFS(int i, boolean[] visited) {
        visited[i] = true;
        System.out.printf(mVexs[i] + ",");
        for (int j = 0; j < mVexs.length; j++) {
            if (mMatrix[i][j] == 1 && !visited[j]) {
                DFS(j, visited);
            }
        }
    }

    private void print() {
        System.out.printf("Martix Graph:\n");
        System.out.println(Arrays.toString(mVexs));
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf(" " + mMatrix[i][j] + ",");
            System.out.printf("\n");
        }
    }

    public MatrixUDG(char[] vexs, char[][] edges) {
        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            mMatrix[p1][p2] = 1;
            mMatrix[p2][p1] = 1;
        }
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for (int i = 0; i < mVexs.length; i++)
            if (mVexs[i] == ch)
                return i;
        return -1;
    }

}
