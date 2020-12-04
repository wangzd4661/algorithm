package lettcode.Q400;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/
 * 贪心算法
 */
public class Q455 {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || s.length == 0 || g.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int si = s.length - 1, gi = g.length - 1;
        int res = 0;
        while (si >= 0 && gi >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                gi--;
                si--;
            } else {
                gi--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] g = new int[]{10, 9, 8, 7};
        int[] s = new int[]{5, 6, 7, 8};
        int res = new Q455().findContentChildren(g, s);
        System.out.println(res);
    }
}
