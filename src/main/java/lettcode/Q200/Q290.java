package lettcode.Q200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 290. 单词规律
 * https://leetcode-cn.com/problems/word-pattern/
 */
public class Q290 {
    public static void main(String[] args) {
        System.out.printf("" + wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String str) {
        if(pattern==null || str==null) {
            return false;
        }
        String[] arr = str.split(" ");
        if(pattern.length()!=arr.length) {
            return false;
        }

        Map<Character,String> map = new HashMap<>();
        for(int i = 0;i<pattern.length();i++) {
            char tmp = pattern.charAt(i);
            if(map.containsKey(tmp)) {
                if(!map.get(tmp).equals(arr[i])) {
                    return false;
                }

            }else {
                if(map.containsValue(arr[i])) {
                    return false;
                }
                map.put(tmp,arr[i]);
            }
        }
        return true;
    }
}
