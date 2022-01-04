package heap;
//伪代码
public class Heap {
    private int[] a; // 数组，从下标 1 开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) return; // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) { // 自下往上堆化
            swap(a, i, i/2); // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
            i = i/2;
        }
    }
    public void removeMax() {
        if (count == 0) return; // 堆中没有数据
        a[1] = a[count];//把最后一个数据当作堆顶元素，然后下沉
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;//先和左子树节点比谁大
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;//大值再和右子树比，记录最大值index
            if (maxPos == i) break;//如果自己比左右子树大，则完成堆化，推出循环
            swap(a, i, maxPos);//和最大值交换
            i = maxPos;
        }
    }
    private void swap(int[] a, int n, int i){

    }
}
