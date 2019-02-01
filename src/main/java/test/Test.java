package test;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("1");
        list.add("2");
        list.add("2");
        //1.
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("2")) {
                list.remove(i);
            }
        }*/
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("2")) {
                list.remove(i);
            }
        }
      /* for (String s : list) {
            if(s.equals("2")){
                list.remove(s);
            }
        }*/
        /*Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String s = itr.next();
            if (s.equals("2")) {
                itr.remove();
            }
        }*/
        int s1=-1;
        int s2=15;
        int s = s1 & s2;
        System.out.println(""+Integer.toBinaryString(s1));
        System.out.println(""+Integer.toBinaryString(s2));
        System.out.println(""+s);
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
