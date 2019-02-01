package test;

import java.lang.reflect.Field;
import java.util.ArrayDeque;

public class TestArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        try {
            Field field = ArrayDeque.class.getDeclaredField("elements");
            field.setAccessible(true);

            Field field1 = ArrayDeque.class.getDeclaredField("head");
            field1.setAccessible(true);

            Field field2 = ArrayDeque.class.getDeclaredField("tail");
            field2.setAccessible(true);

            for (int i = 0; i < 100; i++) {
                list.addFirst(i);
                int arrayLen = ((Object[]) field.get(list)).length;
                int listSize = list.size();

                int head = (int) field1.get(list);
                int tail = (int) field2.get(list);

                System.out.printf("listSize:%d,arrayLen:%d,head:%d,tail:%d%n", listSize, arrayLen, head, tail);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
