package lettcode.Q500;

import java.util.HashMap;

/**
 * 575. 分糖果
 * https://leetcode-cn.com/problems/distribute-candies/
 */
public class Q575 {
    public static void main(String[] args) {
        int size = new Q575().distributeCandies(new int[]{1, 1, 2, 3});
        System.out.printf("" + size);
    }

    public int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int candy : candies) {
            if (map.containsKey(candy)) {
                map.put(candy, map.get(candy) + 1);
            } else {
                map.put(candy, 1);
            }
        }
        int v = candies.length / 2;
        int size = map.keySet().size();
        return size >= v ? v : size;
    }
}
