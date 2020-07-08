package lettcode.interview;

import java.util.*;

public class I16_11 {
    public static void main(String[] args) {
        int[] ints = new I16_11().divingBoard(2, 1118596, 979);
        System.out.println(Arrays.toString(ints));
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        Set<Integer> set = new LinkedHashSet<>();
        int length = 0, n = k;
        while (n >= 0) {
            length = shorter * n + (k - n) * longer;
            set.add(length);
            n--;
        }
        int[] arr = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            arr[i] = iterator.next();
            i++;
        }
        return arr;
    }
}
