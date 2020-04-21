package lettcode.Q200;

import java.util.HashMap;

/**
 * 205. 同构字符串
 * https://leetcode-cn.com/problems/isomorphic-strings/
 */
public class Q205 {
    public static void main(String[] args) {
        System.out.printf("" + isIsomorphic("ab", "aa"));
    }

    public static boolean isIsomorphic(String s, String t) {
        return canExchange(s, t) && canExchange(t, s);
    }

    public static boolean canExchange(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            char sChar = sArr[i];
            char tChar = tArr[i];
            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                map.put(sChar, tChar);
            }
        }
        return true;
    }
}
