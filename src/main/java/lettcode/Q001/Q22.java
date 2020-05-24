package lettcode.Q001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Q22 {
    public static void main(String[] args) {
        List<String> r=new Q22().generateParenthesis(3);
        System.out.printf(""+ Arrays.toString(r.toArray()));
    }

    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n < 1) return res;
        generate("",0,0,n);
        return res;
    }

    private void generate(String str,int open,int close,int max) {

    }

}
