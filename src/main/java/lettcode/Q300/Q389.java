package lettcode.Q300;

import java.util.HashMap;

/**
 * 389. 找不同
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class Q389 {
    public static void main(String[] args) {
        System.out.printf("" + findTheDifference("abbcd", "abbbcd"));
    }

    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        for (Character character : map.keySet()) {
            if (map.get(character) != 0) {
                return character;
            }
        }
        throw new RuntimeException("no answer");
    }
}
