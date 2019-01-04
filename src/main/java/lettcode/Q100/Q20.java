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
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
