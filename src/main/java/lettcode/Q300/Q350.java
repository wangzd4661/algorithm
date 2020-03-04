package lettcode.Q300;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 350. 两个数组的交集 II
 */
public class Q350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        for (int i : nums1) {
            if (treeMap.containsKey(i)) {
                treeMap.put(i, treeMap.get(i) + 1);
            } else {
                treeMap.put(i, 1);
            }
        }
        ArrayList<Integer> list = new ArrayList();
        for (int i : nums2) {
            if (treeMap.containsKey(i)) {
                list.add(i);
                treeMap.put(i, treeMap.get(i) - 1);
                if(treeMap.get(i)==0){
                    treeMap.remove(i);
                }
            }
        }
        int[] n = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            n[i] = list.get(i);
        }
        return n;
    }
}
