package lettcode.Q500;

import unionfind.UnionFind2;
import unionfind.UnionFind6;

import java.util.TreeSet;

/**
 * 547. 朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 */
public class Q547 {
    public static void main(String[] args) {

    }
    public int findCircleNum(int[][] M) {
        int n=M.length;
        UnionFind6 uf=new UnionFind6(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(M[i][j]==1){
                    uf.unionElements(i,j);
                }
            }
        }
        TreeSet<Integer> set=new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(uf.find(i));
        }
        return set.size();
    }
}
