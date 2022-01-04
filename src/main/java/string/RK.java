package string;

public class RK {
    //RK 算法（哈希检索算法）
    //在 BF 算法中，每一个字符都需要进行比较，并且当我们发现首字符匹配时仍然需要比较剩余的所有字符。而在 RK 算法中，就尝试只进行一次比较来判定两者是否相等。
    //一般情况O(m)，最坏O(n*m)
    public static int rk(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[] table = new int[26];
        int[] hash = new int[m - n + 1];
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int s = 1;
        //将26的次方存储在一个表里，取的时候直接用,虽然溢出，但没啥问题
        for (int i = 0; i < 26; i++) {
            table[i] = s;
            s = s * 26;
        }
        //求a中每个字符串Hash值，这样写有问题，复杂度：(m-n+1)*n  m很大，n很小时 复杂度：O(m*n)
        for (int i = 0; i < m - n + 1; i++) {
            int h = 0;
            for (int j = 0; j < n; j++) {
                h = h + (aChars[i + j] - 'a') * table[n - 1 - j];
            }
            hash[i] = h;
        }
        //求b的hash值
        int bHash = 0;
        for (int i = 0; i < n; i++) {
            bHash = bHash + (bChars[i] - 'a') * table[n - 1 - i];
        }
        //对比hash
        for (int i = 0; i < m - n + 1; i++) {
            if (hash[i] == bHash) {//有可能hash冲突，可以再通过bf算法验证下
                return i;
            }
        }
        return -1;
    }
}
