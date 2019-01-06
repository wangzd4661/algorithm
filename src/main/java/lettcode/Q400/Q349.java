package lettcode.Q400;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 349. 两个数组的交集
 */
public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet treeSet = new TreeSet();
        for (int i : nums1) {
            treeSet.add(i);
        }
        ArrayList<Integer> list = new ArrayList();
        for (int i : nums2) {
            if (treeSet.contains(i)) {
                list.add(i);
                treeSet.remove(i);
            }
        }
        int[] n = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            n[i] = list.get(i);
        }
        return n;
    }
}
