package graph;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 使用两种图的存储方式读取testG1.txt文件
        /*String filename = "src\\main\\java\\graph\\testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();

        System.out.println();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename);
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();

        // 使用两种图的存储方式读取testG2.txt文件
        filename = "src\\main\\java\\graph\\testG2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename);
        System.out.println("test G2 in Sparse Graph:");
        g3.show();

        System.out.println();

        DenseGraph g4 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename);
        System.out.println("test G2 in Dense Graph:");
        g4.show();*/

/*        String filename = "src\\main\\java\\graph\\testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);

        ShortestPath bfs2 = new ShortestPath(g,0);
        System.out.print("BFS : ");
        bfs2.showPath(6);*/
//有权图
        /*String filename = "src\\main\\java\\graph\\testG3.txt";
        DenseWeightedGraph<Double> g2 = new DenseWeightedGraph<>(8, false);
        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2, filename);
        System.out.println("test G3 in Dense Graph:");
        g2.show();

        System.out.println();

        String filename2 = "src\\main\\java\\graph\\testG3.txt";
        SparseWeightedGraph<Double> g3 = new SparseWeightedGraph<>(8, false);
        ReadWeightedGraph readGraph3 = new ReadWeightedGraph(g3, filename2);
        System.out.println("test G3 in Dense Graph:");
        g3.show();

        System.out.println();*/



    }
}
