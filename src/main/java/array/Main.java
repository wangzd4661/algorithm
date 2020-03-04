package array;

import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int opCount = 100000;

        MyArrayQueue<Integer> arrayQueue = new MyArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        MyLinkedListQueue<Integer> linkedListQueue = new MyLinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("MyLinkedListQueue, time: " + time3 + " s");

        LinkedList<Integer> linkedList = new LinkedList<>();
        double time4 = testQueue2(linkedList, opCount);
        System.out.println("LinkedList, time: " + time4 + " s");
    }
    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue2(LinkedList<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.addLast(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.pollFirst();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
