package lettcode.Q100;

import java.util.LinkedList;

/**
 * 150.逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class Q150 {

    public static int evalRPN(String[] tokens) {
        Integer sum = 0;
        if (tokens == null || tokens.length == 0) return sum;
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer val1 = stack.pop();
                Integer val2 = stack.pop();
                switch (token) {
                    case "+":
                        sum = val2 + val1;
                        break;
                    case "-":
                        sum = val2 - val1;
                        break;
                    case "*":
                        sum = val2 * val1;
                        break;
                    case "/":
                        sum = val2 / val1;
                        break;
                }
                stack.push(sum);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        int s = evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.printf("s:" + s);
    }
}
