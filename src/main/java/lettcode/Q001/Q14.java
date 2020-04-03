package lettcode.Q001;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Q14 {
    public static void main(String[] args) {
        String[] s = {"flower", "fsow", "flight"};
        String q = longestCommonPrefix(s);
        System.out.print(q);
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
        }
        return sb.toString();
    }
}
