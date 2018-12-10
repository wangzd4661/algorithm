package lettcode.Q100;

/**
 * Created by Administrator on 2018/5/17.
 * 最长公共前缀
 */
public class Q14 {
    public static void main(String[] args) {
        String[] s = {"flower","fsow","flight"};
        String q=longestCommonPrefix(s);
        System.out.print(q);
    }

    public static String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
                index = i;
            }
        }
        String minStr=strs[index];
        for (int i = 0; i < minStr.length(); i++) {
            String match=".*"+minStr.substring(0,minStr.length()-i)+".*";
            boolean bMatch=false;
            for (int j = 0; j < strs.length; j++) {
                if(strs[j].matches(match)){
                    bMatch=true;
                }else{
                    bMatch=false;
                    break;
                }
            }
            if(bMatch){
                match=match.substring(2,match.length()-2);
                return match;
            }
        }
        return "";
    }
}
