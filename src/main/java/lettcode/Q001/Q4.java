package lettcode.Q001;

import java.util.ArrayList;
import java.util.Collections;

public class Q4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2) + "");

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>(nums1.length + nums2.length);
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }
        Collections.sort(list);
        int size = list.size();
        if (size % 2 == 0) {
            int n1 = list.get(size / 2);
            int n2 = list.get((size / 2) - 1);
            return (n1 + n2) / (double)2;
        } else {
            return list.get(size / 2);
        }
    }

}
