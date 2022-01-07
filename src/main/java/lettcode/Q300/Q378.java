package lettcode.Q300;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q378 {
    public static void main(String[] args) {
        int[][] m = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int i = new Q378().kthSmallest(m, 8);
        System.out.println(i);
    }
    //思路一：暴力循环，利用PriorityQueue。
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                queue.offer(anInt);
            }
        }
        for (int i = 0; i < k-1; i++) {
            queue.poll();
        }
        return queue.peek();
    }
    //思路2：利用题目信息，其中每行和每列元素均按升序排序
    // 近乎有序，合并成一维数组，插入排序？ 1 <= n <= 300 arr最大值为90000，O(n^2)算法不太行。归并排序？
    public int kthSmallest2(int[][] matrix, int k) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] arr=new int[m*n];
        for (int i = 0; i < matrix.length; i++) {
            int[] a=matrix[i];
            for (int j = 0; j <a.length ; j++) {
                arr[i*n+j]=a[j];
            }
        }
        for (int i = 1; i < arr.length; i++) {
            int v=arr[i];
            int index=i-1;
            while (index>=0&&arr[index]>v){
                arr[index+1]=arr[index];
                index--;
            }
            arr[index+1]=v;
        }
        return arr[k-1];
    }
    public int kthSmallest3(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }
}
