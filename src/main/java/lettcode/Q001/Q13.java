package lettcode.Q001;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/16.
 * 13.罗马数字转整数
 */
public class Q13 {
    public static void main(String[] args) {
        romanToInt("MMMCMXCIX");
    }

    public static int romanToInt(String s) {
        s = s + "F";
        Map<Character, Integer> map = new HashMap();
        map.put('F', 0);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        char[] val = s.toCharArray();
        for (int i = 0; i < val.length - 1; i++) {
            int f = map.get(val[i]);
            int next = map.get(val[i + 1]);
            if (f < next) {
                int r = next - f;
                sum = sum + r;
                i++;
            } else {
                sum = sum + f;
            }
        }
        return sum;
    }
}
