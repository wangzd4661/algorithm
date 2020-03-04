package lettcode.Q001;

import java.util.LinkedList;

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
        LinkedList linkedList = new LinkedList();
        int i = 0, j = 0;
        while (true) {
            String s = strs[i];
            linkedList.push("");
            break;
        }
        return "";
    }
}
