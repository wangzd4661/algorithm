package lettcode.Q100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Q20 {
    public static void main(String[] args) {
        isValid("{}[]()");
        System.out.printf("" + isValid("()(){({})}[]"));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Deque<Character> stack = new ArrayDeque();
        char[] chars = s.toCharArray();
        stack.push(chars[0]);
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()){
                stack.push(chars[i]);
                continue;
            }
            char first = stack.peek();
            char cur = chars[i];
            if (cur == '}' && first == '{') {
                stack.pop();
            } else if (cur == ']' && first == '[') {
                stack.pop();
            } else if (cur == ')' && first == '(') {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}
