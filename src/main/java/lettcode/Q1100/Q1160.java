package lettcode.Q1100;

import lettcode.Q100.Q160;

/**
 * 1160. 拼写单词
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class Q1160 {
    public static void main(String[] args) {
        int size=new Q1160().countCharacters(new String[]{"hello","world","leetcode"},"welldonehoneyr");
        System.out.printf(""+size);
    }

    public int countCharacters(String[] words, String chars) {
        int size = 0;
        int[] freq = new int[26];
        for (char c : chars.toCharArray()) {
            freq[c - 'a']++;
        }
        for (String word : words) {
            int[] wordFreq = new int[26];
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }
            boolean contains = true;
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] < wordFreq[i]) {
                    contains = false;
                    break;
                }
            }
            if(contains)size=size+word.length();
        }
        return size;
    }
}
