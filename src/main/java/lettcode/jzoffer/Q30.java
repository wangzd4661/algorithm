package lettcode.jzoffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Q30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.min());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
    }
}

class MinStack {
    private Deque<Integer> stack;
    private PriorityQueue<Integer> queue;

    public MinStack() {
        stack = new LinkedList<>();
        queue=new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        queue.offer(x);
    }

    public void pop() {
        int v=stack.pop();
        queue.remove(v);
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return queue.peek();
    }
}
