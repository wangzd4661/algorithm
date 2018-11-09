package sort;

public abstract class Sort {
    abstract void sort(int[] args);

    void exch(int[] args, int i, int j) {
        int temp = args[j];
        args[j] = args[i];
        args[i] = temp;
    }
}
