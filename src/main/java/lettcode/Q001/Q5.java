package lettcode.Q001;


public class Q5 {
    public static void main(String[] args) {
       String res= new Q5().longestPalindrome2("esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq");
        System.out.println(res);
    }
    //暴力破解：n^2
    public String longestPalindrome2(String s) {
        if(s.length()<2)return s;
        char[] ch=s.toCharArray();
        int len=ch.length;
        int maxLen=1;
        int begin=0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if(j-i+1>maxLen&&isPalindrome(ch,i,j)){
                    begin=i;
                    maxLen=j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    public boolean isPalindrome(char[] ch,int i,int j){
        while (i<j){
            if(ch[i]!=ch[j])return false;
            i++;
            j--;
        }
        return true;
    }
}
