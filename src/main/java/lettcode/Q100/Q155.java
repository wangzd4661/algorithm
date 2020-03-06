package lettcode.Q100;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 155.最小栈
 */
public class Q155 {
    public class MinStack {
        /**
         * initialize your data structure here.
         */
        LinkedList<Integer> data, helper;

        public MinStack() {
            data = new LinkedList<>();
            helper = new LinkedList<>();
        }

        public void push(int x) {
            data.push(x);
            if (helper.isEmpty() || helper.peekFirst() > x) {
                helper.push(x);
            } else if (helper.peekFirst() <= x) {
                helper.push(helper.peekFirst());
            }
        }

        public void pop() {
            if (data.isEmpty()) throw new RuntimeException("MinStack is Empty");
            data.pop();
            helper.pop();
        }

        public int top() {
            if (data.isEmpty()) throw new RuntimeException("MinStack is Empty");
            return data.peekFirst();
        }

        public int getMin() {
            if (data.isEmpty()) throw new RuntimeException("MinStack is Empty");
            return helper.peekFirst();
        }
    }
}
