package lettcode.Q100;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/16.
 *回文数
 *
 */
public class Q9 {
    public static void main(String[] args) {
        int i = 1234321;
        System.out.println(isPalindrome2(i)+"");
    }

    /**
     * 使用 String
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String s = x + "";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        if (s.equals(sb.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome2(int x) {
        int first = x;
        int s;
        ArrayList<Integer> list = new ArrayList();
        while (x > 0) {
            s = x % 10;
            list.add(0, s);
            x = x / 10;
        }
        int sum = 0;
        for (int j = list.size() - 1; j >= 0; j--) {
            sum = sum + ((int) Math.pow(10, j) * list.get(j));
        }
        if (sum == first) {
            return true;
        } else {
            return false;
        }
    }
}
