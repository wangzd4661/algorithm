package lettcode.Q200;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 */
public class Q119 {
    public static void main(String[] args) {
        List<Integer> list = getRow(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("" + list.get(i) + ",");
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <=rowIndex; i++) {
            list.clear();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(last.get(j - 1) + last.get(j));
            }
            if (i > 0) list.add(1);
            last = (List<Integer>) ((ArrayList<Integer>) list).clone();
        }
        return list;
    }
}
