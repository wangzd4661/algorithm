package lettcode.Q001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/submissions/
 */
public class Q17 {
    public static void main(String[] args) {
        List<String> list=new Q17().letterCombinations("23");
        System.out.printf(""+ Arrays.toString(list.toArray()));

    }
    private List<String> res=new ArrayList<>();
    private String[] letterMap={
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    /**
     * 思路：树形问题，用递归实现。
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        res.clear();
        if(digits==null||digits.length()==0)return res;
        char[] chars=digits.toCharArray();
        findLetter(chars,0,"");
        return res;
    }
    private void findLetter(char[] chars,int index,String s){
        if(index==chars.length){
            res.add(s);
            return;
        }
        String letter=letterMap[chars[index]-'0'];
        char[] letterChar=letter.toCharArray();
        for (int i = 0; i < letterChar.length; i++) {
            findLetter(chars,index+1,s+letterChar[i]);
        }
    }
}
