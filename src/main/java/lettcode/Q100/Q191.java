package lettcode.Q100;

/**
 * 191. 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class Q191 {
    public static void main(String[] args) {
        int c=new Q191().hammingWeight(11);
        System.out.printf(""+c);
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
}
