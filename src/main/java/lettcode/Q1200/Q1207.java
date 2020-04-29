package lettcode.Q1200;

import java.util.HashMap;
import java.util.HashSet;

public class Q1207 {
    public static void main(String[] args) {
        boolean v=new Q1207().uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0});
        System.out.printf(""+v);
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 0);
            }
        }
        HashSet<Integer> set = new HashSet();
        for (Integer value : map.values()) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }

}
