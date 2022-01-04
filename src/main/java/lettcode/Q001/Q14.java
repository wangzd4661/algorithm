package lettcode.Q001;


import trie.Trie;

import java.util.TreeMap;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Q14 {
    public static void main(String[] args) {
        //String[] s = {"flower","flow","flight"};
        //String[] s = {"dog","racecar","car"};
        String[] s = {"ab","a"};
        String q = new Q14().longestCommonPrefix(s);
        System.out.println(q);
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
