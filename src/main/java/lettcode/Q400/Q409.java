package lettcode.Q400;

import java.util.HashMap;

/**
 * 409. 最长回文串
 * https://leetcode-cn.com/problems/longest-palindrome/
 */
public class Q409 {
    public static void main(String[] args) {
        System.out.println("Q409.main:" + longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.remove(c);
                size = size + 2;
            } else {
                map.put(c, 1);
            }
        }
        return size + (map.isEmpty() ? 0 : 1);
    }
}
