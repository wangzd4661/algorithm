package lettcode.Q100;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class Q118 {
    public static void main(String[] args) {
        List<List<Integer>> list = generate2(5);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> lastList = list.get(i);
            for (int j = 0; j < lastList.size(); j++) {
                System.out.printf(lastList.get(j) + ",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        List<Integer> innerList1 = new ArrayList<>();
        innerList1.add(1);
        list.add(innerList1);
        if (numRows == 1) return list;
        List<Integer> innerList2 = new ArrayList<>();
        innerList2.add(1);
        innerList2.add(1);
        list.add(innerList2);
        if (numRows == 2) return list;
        for (int i = 2; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            innerList.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> lastList = list.get(i - 1);
                innerList.add(lastList.get(j - 1) + lastList.get(j));
            }
            innerList.add(1);
            list.add(innerList);
        }
        return list;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            innerList.add(1);
            for (int j = 1; j < i; j++) {
                innerList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            if(i>0) innerList.add(1);
            list.add(innerList);
        }
        return list;
    }
}
