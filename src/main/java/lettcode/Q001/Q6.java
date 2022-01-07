package lettcode.Q001;

public class Q6 {
    public static void main(String[] args) {
        String paypalishiring = new Q6().convert("PAYPALISHIRING", 3);
        //PAYPALISHIRING
        //P   A   H   N
        //A P L S I I G
        //Y   I   R
        //PAHNAPLSIIGYIR
        System.out.println(paypalishiring);
        System.out.println("PAHNAPLSIIGYIR");
        if(paypalishiring.equals("PAHNAPLSIIGYIR")) System.out.println("ok");
    }

    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        StringBuilder[] sbList = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbList[i] = new StringBuilder();
        }
        char[] chars = s.toCharArray();
        int curRow = 0;
        boolean goingDown = false;
        for (int i = 0; i < chars.length; i++) {
            sbList[curRow].append(chars[i]);
            if(curRow==0||curRow==numRows-1)goingDown=!goingDown;
            curRow=curRow+(goingDown?1:-1);
        }
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            System.out.println(sbList[i]);
            res.append(sbList[i]);
        }
        return res.toString();
    }
}
