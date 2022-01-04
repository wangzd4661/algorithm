package lettcode.Q200;

/**
 * 231. 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class Q231 {
    public static void main(String[] args) {

    }
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0)
            return false;
        return isPowerOfTwo2(n / 2);
    }
}
