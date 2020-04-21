package lettcode.Q400;

import javafx.util.Pair;

import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 */
public class Q451 {
    public static void main(String[] args) {
        System.out.printf("" + frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray())
            freq[c]++;
        PriorityQueue<Pair<Character, Integer>> lst = new PriorityQueue<>((t1, t2) -> t2.getValue() - t1.getValue());
        for (char c = 0; c < 256; c++)
            if (freq[c] != 0)
                lst.offer(new Pair(c, freq[c]));
        StringBuilder sb = new StringBuilder();
        int size = lst.size();
        for (int i = 0; i < size; i++) {
            Pair<Character, Integer> p = lst.poll();
            for (int j = 0; j < p.getValue(); j++) {
                sb.append(p.getKey());
            }
        }
        return sb.toString();

    }
}
