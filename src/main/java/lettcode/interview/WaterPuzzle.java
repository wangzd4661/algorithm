package lettcode.interview;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 一个5升桶，一个3升桶，得到一个4升的水
 */
public class WaterPuzzle {
    private int[] pre;
    private int end = -1;

    public WaterPuzzle() {
        boolean[] visited = new boolean[100];
        pre = new int[100];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            int a = cur / 10, b = cur % 10;
            // max a = 5, max b = 3
            ArrayList<Integer> nexts = new ArrayList<>();
            nexts.add(5 * 10 + b);//5升桶倒满
            nexts.add(a * 10 + 3);//3升桶倒满
            nexts.add(a * 10 + 0);//5升桶倒完
            nexts.add(0 * 10 + b);//3升桶倒完
            int x = Math.min(a, 3 - b);//5升往3升倒
            nexts.add((a - x) * 10 + (b + x));
            int y = Math.min(b, 5 - a);//3升往5升倒
            nexts.add((a + y) * 10 + (b - y));

            for (Integer next : nexts) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    pre[next] = cur;
                    if (next / 10 == 4 || next % 10 == 4) {
                        end = next;
                        return;//找到了
                    }
                }
            }
        }
    }

    public Iterable<Integer> result() {
        ArrayList<Integer> res = new ArrayList<>();
        if (end == -1) return res;
        int cur = end;
        while (cur != 0) {
            res.add(cur);
            cur = pre[cur];
        }
        res.add(0);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new WaterPuzzle()).result());
    }
}
