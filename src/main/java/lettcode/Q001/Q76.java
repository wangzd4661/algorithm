package lettcode.Q001;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class Q76 {
    public static void main(String[] args) {
        System.out.printf(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        int l = 0, r = -1;
        int start = -1, minLength = s.length() + 1;
        int match = 0;
        int[] needs = new int[256];
        int[] window = new int[256];
        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }
        while (l < s.length()) {
            if (r + 1 < s.length() && match < t.length()) {
                r++;
                char c = s.charAt(r);
                window[c]++;
                if (window[c] <= needs[c]) {
                    match++;
                }
            } else {
                assert (match == t.length());
                if (match == t.length() && r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }
                char c = s.charAt(l);
                window[c]--;
                if (window[c] < needs[c]) {
                    match--;
                }
                l++;
            }
        }
        if (start != -1) {
            return s.substring(start, start + minLength);
        }
        return "";
    }

}
