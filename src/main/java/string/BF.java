package string;

public class BF {
    public static int bf(String T, String P) {
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
}
