package heap;

import array.Queue;

public class MyPriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> heap;

    public MyPriorityQueue() {
        heap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }


    @Override
    public void enqueue(E e) {
        heap.add(e);
    }

    @Override
    public E dequeue() {
        return heap.extractMax();
    }

    @Override
    public E getFront() {
        return heap.findMax();
    }
}
