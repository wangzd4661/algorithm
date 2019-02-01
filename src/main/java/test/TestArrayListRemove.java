package test;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayListRemove {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("2");
        list.add("2");
        list.add("1");
        list.add("2");
        list.add("2");
        remove4(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("list:" + list.get(i) + "\t");
        }
    }

    //result: list:2	list:1	list:2
    private static void remove1(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("2")) {
                list.remove(i);
            }
        }
    }

    //result: ConcurrentModificationException
    private static void remove2(ArrayList<String> list) {
        for (String s : list) {
            if (s.equals("2")) {
                list.remove(s);
            }
        }
    }

    //result: list:1
    private static void remove3(ArrayList<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("2")) {
                list.remove(i);
            }
        }
    }

    //result: list:1
    private static void remove4(ArrayList<String> list) {
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String s = itr.next();
            if (s.equals("2")) {
                itr.remove();
            }
        }
    }
}
