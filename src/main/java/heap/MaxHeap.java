package heap;

import array.MyArray;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {
    private MyArray<E> data;

    public MaxHeap(int capacity) {
        data = new MyArray(capacity);
    }

    public MaxHeap() {
        data = new MyArray();
    }
    public MaxHeap(E[] arr) {
        data = new MyArray(arr);
        for (int i = parent(arr.length-1); i >=0 ; i--) {
            siftDown(i);
        }
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    // 看堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1); //最大元素和最后一个交换位置
        data.removeLast();//删除最大元素
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            //找最大值
            int j = leftChild(k);
            //有右孩子且右孩子大于左孩子
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = j + 1;
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) break;
            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


    public static void main(String[] args) {

        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        MaxHeap<Integer> maxHeap = new MaxHeap<>(testData);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < n; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed.");
    }
}
