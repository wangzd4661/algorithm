package test;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        ArrayList<Integer> list1 = (ArrayList<Integer>) list.clone();
        list.remove(1);
        for (Integer integer : list) {
            System.out.println(""+integer);
        }
        for (Integer integer : list1) {
            System.out.println(""+integer);
        }


    }

    public static void testArrayListResize() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        for (int i = 0; i < 100; i++) {
            list.add(i);
            int arrayLen = ((Object[]) field.get(list)).length;
            int listSize = list.size();
            System.out.printf("listSize:%d,arrayLen:%d%n", listSize, arrayLen);
        }
    }
}
