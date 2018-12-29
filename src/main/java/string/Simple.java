package string;

/**
 * 字符串搜索算法
 */
public class Simple {
    public static void main(String[] args) {
        System.out.printf("" + kmp("googlehegolc", "golc"));
    }

    /**
     * 朴素算法
     *
     * @param T ---n
     * @param P ---m
     * @return (n - m + 1)*m
     * O(n*m)
     */
    public static int pm(String T, String P) {
        int i = 0, j = 0;
        while (i < T.length() && j < P.length()) {
            if (T.charAt(i) == P.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == P.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * KMP算法
     *
     * @param T ---n
     * @param P ---m
     * @return O(n + m)
     */
    public static int kmp(String T, String P) {
        int i = 0, j = 0;
        int[] next = getNext(P);//m
        while (i < T.length() && j < P.length()) {//n
            if (j == -1 || T.charAt(i) == P.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == P.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] getNext(String P) {
        int[] next = new int[P.length()];
        next[0] = -1;
        int i = 0, j = -1;

        while (i < P.length() - 1) {
            if (j == -1 || P.charAt(i) == P.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * BM算法
     *
     * @param T
     * @param P
     * @return
     */
    public static int bm(String T, String P) {
        int n = T.length();
        int m = P.length();
        int skip = 0;
        int[] bad=getBad();
        for (int i = 0; i < n - m; i += skip) {
            skip=0;
            for (int j = 0; j >=0; j++) {

            }
        }
        return 0;
    }

    private static int[] getBad() {
        return new int[0];
    }

}
