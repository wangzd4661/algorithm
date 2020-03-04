package lettcode.Q001;

/**
 * 3. 无重复字符的最长子串
 */
public class Q3 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int lastPointer = 0, prePointer = 1;
     /*   for (int i = 0; i < chars.length; i++) {
            twoPointer = i ;
            if (chars[twoPointer] != chars[onePointer]) {

            }
        }*/
        while (prePointer < chars.length) {
            if (chars[prePointer] != chars[lastPointer]) {
                prePointer++;
            } else {
                prePointer++;
                lastPointer++;
            }
        }

        return prePointer - lastPointer + 1;
    }
}
