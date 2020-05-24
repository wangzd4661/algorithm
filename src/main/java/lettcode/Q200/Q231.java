package lettcode.Q200;

/**
 * 231. 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class Q231 {
    public static void main(String[] args) {

    }
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
