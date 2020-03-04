package lettcode.Q200;

import java.util.LinkedList;

/**
 * Q225.用队列实现栈
 */
public class Q225 {
    static class MyStack {
        private LinkedList<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.addFirst(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.removeFirst();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peekFirst();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
