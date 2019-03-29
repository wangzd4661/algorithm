package lettcode.Q300;

import java.util.ArrayDeque;

/**
 * 232. 用栈实现队列
 */
public class Q232 {
    static class MyQueue {
        private ArrayDeque<Integer> deque;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            deque = new ArrayDeque<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            deque.addLast(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return deque.removeFirst();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return deque.peekFirst();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return deque.isEmpty();
        }
    }
}
