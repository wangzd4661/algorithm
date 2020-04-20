package lettcode.Q200;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * 202. 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 */
public class Q202 {
    public static void main(String[] args) {
        System.out.println("Q202.main"+isHappy(2));
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet();
        set.add(n);
        while (n!=1){
            n=op(n);
            if(set.contains(n)){
                return false;
            }else {
                set.add(n);
            }
        }
        return true;
    }

    private static int op(int n) {
        int ret=0;
        while (n!=0){
            int t=n%10;
            ret=ret+t*t;
            n=n/10;
        }
        return ret;
    }
}
